package com.example.codecraft.game;

import com.example.codecraft.Settings;
import com.raylib.Jaylib.Vector2;
import org.python.core.PyDictionary;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

import static com.raylib.Jaylib.*;

public class Game {
    private static final Camera2D camera = new Camera2D();
    private final WorldMap worldMap;
    private final Player player;

    public Game() {
        var tilemapTexture = LoadTexture("assets/ground_tilemap.png");
        var characterTexture = LoadTexture("assets/Character.png");
        var blocksTexture = LoadTexture("assets/Blocks.png");
        var seaTexture = LoadTexture("assets/Sea.png");

        Vector2 tileDimensions = new Vector2(16, 16);
        Tilemap groundTilemap = new Tilemap(tilemapTexture, tileDimensions);
        Tilemap blocksTilemap = new Tilemap(blocksTexture, tileDimensions);

        int worldSizeX = 16;
        int worldSizeY = 16;
        worldMap = new WorldMap(worldSizeX, worldSizeY, groundTilemap, blocksTilemap, seaTexture);

        Vector2 playerPosition = new Vector2(worldSizeX * tileDimensions.x() / 2, worldSizeY * tileDimensions.y() / 2);
        Spritesheet spritesheet = new Spritesheet(characterTexture, 4);
        player = new Player(playerPosition, spritesheet);

        camera.target(playerPosition);
        camera.offset(new Vector2(Codecraft.getWidth() / 2.0f, Codecraft.getHeight() / 2.0f));
        camera.zoom(3.0f);

        executePython();
    }

    private void executePython() {
        try (PythonInterpreter interpreter = new PythonInterpreter()) {
            interpreter.set("player", player);
            interpreter.set("world", worldMap);

            interpreter.exec("from com.example.codecraft.game import Vector2");
            interpreter.exec("from com.example.codecraft.game import Vector2Int");
            interpreter.exec("from com.example.codecraft.game import KeyCode");
            interpreter.exec("from com.example.codecraft.game import BlockType");
            interpreter.exec("from com.example.codecraft.game import Mouse");
            interpreter.exec("from com.example.codecraft.game.KeyListener import setAction");
            interpreter.execfile(Settings.fullPythonSourcePath);

            //printPythonFunctions(interpreter);
        }
    }

    private void printPythonFunctions(PythonInterpreter interpreter) {
        interpreter.exec("import inspect");
        PyDictionary dict = (PyDictionary) interpreter.eval("dict([(k, inspect.getargspec(v).args) for (k, v) in locals().items() if inspect.isfunction(v)])");
        ConcurrentMap<PyObject, PyObject> map= dict.getMap();
        map.forEach((name, arguments)->{
            System.out.println(name.toString());
            System.out.println(arguments.toString());
        });
    }

    public void update() {
        camera.target(new Vector2(player.position.x, player.position.y));

        KeyListener.listen();

        BeginMode2D(camera);

        worldMap.render();
        player.render();

        EndMode2D();
    }

    static Camera2D getCamera() {
        return camera;
    }
}
