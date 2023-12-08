package game;

import com.raylib.Jaylib.Vector2;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawTextureRec;

public class WorldMap {
    private final Tilemap tilemap;
    private final int sizeX;
    private final int sizeY;

    public WorldMap(int sizeX, int sizeY, Tilemap tilemap) {
        this.tilemap = tilemap;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void render() {
        for (int x = 0; x < sizeX; ++x) {
            for (int y = 0; y < sizeY; ++y) {
                DrawTextureRec(tilemap.getTexture(), tilemap.getTile(0, 2), new Vector2(16 * x, 16 * y), WHITE);
            }
        }
    }
}
