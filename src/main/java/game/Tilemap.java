package game;

import static com.raylib.Jaylib.*;

import com.raylib.Jaylib.Vector2;
import com.raylib.Jaylib.Rectangle;

public class Tilemap {
    private final Texture texture;
    private final Vector2 tileDimensions;
    private final int xTiles;
    private final int yTiles;

    public Tilemap(Texture tilemapTexture, Vector2 tileDimensions) {
        texture = tilemapTexture;
        this.tileDimensions = tileDimensions;

        xTiles = (int) (texture.width() / tileDimensions.x());
        yTiles = (int) (texture.height() / tileDimensions.y());
    }

    public Rectangle getTile(int xOffset, int yOffset) {
        if (xOffset >= xTiles || yOffset >= yTiles || xOffset < 0 || yOffset < 0) {
            throw new IndexOutOfBoundsException("Tilemap out of bounds");
        }

        return new Rectangle(xOffset * tileDimensions.x(), yOffset * tileDimensions.y(), tileDimensions.x(), tileDimensions.y());
    }

    public Texture getTexture() {
        return texture;
    }
}
