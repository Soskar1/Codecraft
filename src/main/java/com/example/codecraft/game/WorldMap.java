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
    private final ArrayList<Block> blocks = new ArrayList<>();
    private final Block[][] placedBlocks;

    public WorldMap(int sizeX, int sizeY, Tilemap groundTilemap, Tilemap blockTilemap) {
        this.groundTilemap = groundTilemap;
        this.blockTilemap = blockTilemap;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        placedBlocks = new Block[sizeX][sizeY];

        blocks.add(new Block(blockTilemap.getTile(0, 0))); // stone brick
        blocks.add(new Block(blockTilemap.getTile(0, 1))); // wood
        blocks.add(new Block(blockTilemap.getTile(1, 0))); // bricks
        blocks.add(new Block(blockTilemap.getTile(1, 1))); // rock
    }

    @Override
    public void render() {
        for (int x = 0; x < sizeX; ++x) {
            for (int y = 0; y < sizeY; ++y) {
                DrawTextureRec(groundTilemap.getTexture(), groundTilemap.getTile(0, 2), new Vector2(16 * x, 16 * y), WHITE);

                Block block = placedBlocks[x][y];
                if (block != null) {
                    DrawTextureRec(blockTilemap.getTexture(), block.getTexture(), new Vector2(16 * x, 16 * y), WHITE);
                }
            }
        }
    }

    public void placeBlock(BlockType blockType, int x, int y) {
        placedBlocks[x][y] = blocks.get(blockType.ordinal());
    }

    public void placeBlock(BlockType blockType, com.example.codecraft.game.Vector2 worldPosition) {
        Vector2Int localPosition = convertToGridCoordinates(worldPosition);
        if (localPosition.x != -1) {
            placedBlocks[localPosition.x][localPosition.y] = blocks.get(blockType.ordinal());
        }
    }

    public void destroyBlock(com.example.codecraft.game.Vector2 worldPosition) {
        Vector2Int localPosition = convertToGridCoordinates(worldPosition);
        if (localPosition.x != -1) {
            placedBlocks[localPosition.x][localPosition.y] = null;
        }
    }

    private Vector2Int convertToGridCoordinates(com.example.codecraft.game.Vector2 worldPosition) {
        int localX = (int)(worldPosition.x / sizeX);
        int localY = (int)(worldPosition.y / sizeY);

        if (localX >= sizeX || localY >= sizeY || localX < 0 || localY < 0) {
            return new Vector2Int(-1, -1);
        }

        return new Vector2Int(localX, localY);
    }
}
