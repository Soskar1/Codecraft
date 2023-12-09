package com.example.codecraft.game;

import com.raylib.Jaylib.Vector2;

import java.util.ArrayList;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawTextureRec;

public class WorldMap implements Renderable {
    private final Tilemap groundTilemap;
    private final Tilemap blockTilemap;
    private final int sizeX;
    private final int sizeY;
    private ArrayList<Block> placedBlocks = new ArrayList<>();

    public WorldMap(int sizeX, int sizeY, Tilemap groundTilemap, Tilemap blockTilemap) {
        this.groundTilemap = groundTilemap;
        this.blockTilemap = blockTilemap;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        placeBlock(new Block(groundTilemap.getTile(0, 0), new Vector2(200, 200)));
    }

    @Override
    public void render() {
        for (int x = 0; x < sizeX; ++x) {
            for (int y = 0; y < sizeY; ++y) {
                DrawTextureRec(groundTilemap.getTexture(), groundTilemap.getTile(0, 2), new Vector2(16 * x, 16 * y), WHITE);
            }
        }

        for (Block block : placedBlocks) {
            DrawTextureRec(blockTilemap.getTexture(), block.getTexture(), block.getPosition(), WHITE);
        }
    }

    public void placeBlock(Block block) {
        placedBlocks.add(block);
    }
}
