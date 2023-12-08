package game;

import com.raylib.Jaylib.Vector2;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;

public class Game {
    private final Camera2D camera;
    private final WorldMap worldMap;

    public Game() {
        var texture = LoadTexture("assets/ground_tilemap.png");
        Vector2 tileDimensions = new Vector2(16, 16);
        Tilemap tilemap = new Tilemap(texture, tileDimensions);

        int worldSizeX = 32;
        int worldSizeY = 32;
        worldMap = new WorldMap(worldSizeX, worldSizeY, tilemap);

        camera = new Camera2D();
        camera.target(new Vector2(worldSizeX * tileDimensions.x() / 2, worldSizeY * tileDimensions.y() / 2));
        camera.offset(new Vector2(Codecraft.getWidth() / 2.0f, Codecraft.getHeight() / 2.0f));
        camera.zoom(3.0f);
    }

    public void update() {
        BeginMode2D(camera);

        worldMap.render();

        EndMode2D();
    }
}
