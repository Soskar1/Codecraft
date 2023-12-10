package com.example.codecraft.game;

import com.raylib.Jaylib.Rectangle;

public class Block {
    private final Rectangle texture;

    public Block(Rectangle texture) {
        this.texture = texture;
    }

    public Rectangle getTexture() {
        return texture;
    }
}
