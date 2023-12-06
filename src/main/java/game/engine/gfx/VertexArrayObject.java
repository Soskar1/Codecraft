package game.engine.gfx;


import static org.lwjgl.opengl.GL30.*;

public class VertexArrayObject {
    private int id;

    public VertexArrayObject() {
        id = glGenVertexArrays();
        glBindVertexArray(id);
    }

    public void bind() {
        glBindVertexArray(id);
    }

    public void unbind() {
        glBindVertexArray(0);
    }
}
