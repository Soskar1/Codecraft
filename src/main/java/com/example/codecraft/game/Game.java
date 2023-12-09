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

        Vector2 tileDimensions = new Vector2(16, 16);
        Tilemap tilemap = new Tilemap(tilemapTexture, tileDimensions);

        int worldSizeX = 32;
        int worldSizeY = 32;
        worldMap = new WorldMap(worldSizeX, worldSizeY, tilemap);

        Vector2 playerPosition = new Vector2(worldSizeX * tileDimensions.x() / 2, worldSizeY * tileDimensions.y() / 2);
        Spritesheet spritesheet = new Spritesheet(characterTexture, 4);
        player = new Player(playerPosition, spritesheet);

        camera = new Camera2D();
        camera.target(playerPosition);
        camera.offset(new Vector2(Codecraft.getWidth() / 2.0f, Codecraft.getHeight() / 2.0f));
        camera.zoom(3.0f);

        try (PythonInterpreter interpreter = new PythonInterpreter()) {
            interpreter.execfile(Settings.fullPythonSourcePath);
        }
    }

    public void update() {
        BeginMode2D(camera);

        worldMap.render();
        player.render();

        EndMode2D();
    }
}
