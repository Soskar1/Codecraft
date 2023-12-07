package game;

import static com.raylib.Jaylib.*;

public class Codecraft implements Runnable {
    private static final int width = 1280;
    private static final int height = 720;

    @Override
    public void run() {
        InitWindow(width, height, "Codecraft");
        SetTargetFPS(60);

        Game game = new Game();

        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(WHITE);

            game.update();

            EndDrawing();
        }

        CloseWindow();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
