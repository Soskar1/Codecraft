package game;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class Codecraft implements Runnable {

    @Override
    public void run() {
        InitWindow(1280, 720, "Codecraft");

        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RED);
            DrawRectangle(100, 200, 100, 250, BLUE);
            DrawCircle(400, 400, 50, YELLOW);
            EndDrawing();
        }
    }
}
