package game;

import com.raylib.Jaylib.Vector2;

import static com.raylib.Jaylib.*;

public class Game {
    private final Texture texture;
    private final Camera2D camera;
    private final Tilemap tilemap;

    public Game() {
        texture = LoadTexture("assets/ground_tilemap.png");
        tilemap = new Tilemap(texture, new Vector2(16, 16));

        camera = new Camera2D();
        camera.target(new Vector2(100, 200));
        camera.offset(new Vector2(Codecraft.getWidth() / 2.0f, Codecraft.getHeight() / 2.0f));
        camera.zoom(5.0f);
    }

    public void update() {
        BeginMode2D(camera);

        DrawTextureRec(tilemap.getTexture(), tilemap.getTile(0, 0), new Vector2(100, 200), WHITE);

        EndMode2D();
    }
}
