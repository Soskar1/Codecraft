package com.example.codecraft.game;

import com.raylib.Jaylib.Vector2;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawTextureRec;

public class Player implements Renderable {
    private final Spritesheet spritesheet;
    private Vector2 position;
    private Vector2 velocity = new Vector2();
    private float speed = 1;

    public Player(Vector2 position, Spritesheet spritesheet) {
        this.position = position;
        this.spritesheet = spritesheet;
    }

    public void setPosition(Vector2 newPosition) {
        position = newPosition;
    }

    public void setPosition(float x, float y) {
        position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setSpeed(float newSpeed) {
        speed = newSpeed;
    }

    public float getSpeed() {
        return speed;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    @Override
    public void render() {
        DrawTextureRec(spritesheet.getTexture(), spritesheet.getSprite(0, 0), position, WHITE);
    }
}
