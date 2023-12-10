package com.example.codecraft.game;

import static com.raylib.Raylib.GetMousePosition;
import static com.raylib.Raylib.GetScreenToWorld2D;

public class Mouse {
    public static Vector2 getWorldPosition() {
        var mousePositionScreen = GetMousePosition();
        var mousePositionWorld = GetScreenToWorld2D(mousePositionScreen, Game.getCamera());
        return new Vector2(mousePositionWorld.x(), mousePositionWorld.y());
    }
}
