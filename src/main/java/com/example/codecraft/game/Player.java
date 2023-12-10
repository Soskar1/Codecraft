package com.example.codecraft.game;

import com.raylib.Jaylib;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;

public class Player implements Renderable {
    private final Spritesheet spritesheet;
    public Vector2 position;

    public Player(Jaylib.Vector2 position, Spritesheet spritesheet) {
        this.position = new Vector2(position.x(), position.y());
        this.spritesheet = spritesheet;
    }

    @Override
    public void render() {
        DrawTextureRec(spritesheet.getTexture(), spritesheet.getSprite(0, 0), new Jaylib.Vector2(position.x, position.y), WHITE);
    }
}
