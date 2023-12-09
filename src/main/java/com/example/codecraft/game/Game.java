package com.example.codecraft.game;

import com.example.codecraft.Settings;
import com.raylib.Jaylib.Vector2;
import org.python.util.PythonInterpreter;

import static com.raylib.Jaylib.*;

public class Game {
    private final Camera2D camera;
    private final WorldMap worldMap;
    private final Player player;

    public Game() {
        var tilemapTexture = LoadTexture("assets/ground_tilemap.png");
        var characterTexture = LoadTexture("assets/Character.png");
        var blocksTexture = LoadTexture("assets/Blocks.png");

        Vector2 tileDimensions = new Vector2(16, 16);
        Tilemap groundTilemap = new Tilemap(tilemapTexture, tileDimensions);
        Tilemap blocksTilemap = new Tilemap(blocksTexture, tileDimensions);

        int worldSizeX = 32;
        int worldSizeY = 32;
        worldMap = new WorldMap(worldSizeX, worldSizeY, groundTilemap, blocksTilemap);

        Vector2 playerPosition = new Vector2(worldSizeX * tileDimensions.x() / 2, worldSizeY * tileDimensions.y() / 2);
        Spritesheet spritesheet = new Spritesheet(characterTexture, 4);
        player = new Player(playerPosition, spritesheet);

        camera = new Camera2D();
        camera.target(playerPosition);
        camera.offset(new Vector2(Codecraft.getWidth() / 2.0f, Codecraft.getHeight() / 2.0f));
        camera.zoom(3.0f);

        executePython();
    }

    private void executePython() {
        try (PythonInterpreter interpreter = new PythonInterpreter()) {
            interpreter.set("player", player);

            interpreter.exec("from com.example.codecraft.game import KeyCode");
            interpreter.exec("from com.example.codecraft.game.KeyListener import setAction");
            interpreter.execfile(Settings.fullPythonSourcePath);

            //interpreter.exec("import inspect");
            //PyDictionary dict = (PyDictionary) interpreter.eval("dict([(k, inspect.getargspec(v).args) for (k, v) in locals().items() if inspect.isfunction(v)])");
            //ConcurrentMap<PyObject, PyObject> map= dict.getMap();
            //map.forEach((name, arguments)->{
            //    System.out.println(name.toString());
            //    System.out.println(arguments.toString());
            //});
        }
    }

    public void update() {
        camera.target(new Vector2(player.position.x, player.position.y));
        KeyListener.listen();

        BeginMode2D(camera);

        worldMap.render();
        player.render();

        EndMode2D();
    }
}
