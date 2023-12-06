package game.engine.gfx;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;

public class ElementBufferObject {
    private int id;

    public ElementBufferObject(IntBuffer indices) {
        id = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);
    }
}
