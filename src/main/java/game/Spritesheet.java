package game;

import com.raylib.Jaylib.Rectangle;
import com.raylib.Raylib.Texture;

public class Spritesheet {
    private final Texture texture;
    private final int spriteDimensions;

    public Spritesheet(Texture texture, int size) {
        this.texture = texture;
        spriteDimensions = texture.width() / size;
    }

    public Rectangle getSprite(int row, int column) {
        return new Rectangle(row * spriteDimensions, column * spriteDimensions, spriteDimensions, spriteDimensions);
    }

    public Texture getTexture() {
        return texture;
    }
}
