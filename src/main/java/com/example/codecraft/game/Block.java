package com.example.codecraft.game;

import com.raylib.Jaylib.Vector2;
import com.raylib.Jaylib.Rectangle;

public class Block {
    private Rectangle texture;
    private Vector2 position;

    public Block(Rectangle texture, Vector2 position) {
        this.texture = texture;
        this.position = position;
    }

    public Rectangle getTexture() {
        return texture;
    }

    public Vector2 getPosition() {
        return position;
    }
}
