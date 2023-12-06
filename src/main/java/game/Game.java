package game;

import game.engine.gfx.*;
import org.lwjgl.BufferUtils;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL20.*;

public class Game {
    private ShaderProgram shaderProgram;
    private VertexArrayObject vao;
    private VertexBufferObject vbo;
    private ElementBufferObject ebo;

    private float[] vertexArray = {
            //position              color
            0.5f, -0.5f, 0.0f,      1.0f, 0.0f, 0.0f, 1.0f,
            -0.5f, 0.5f, 0.0f,      0.0f, 1.0f, 0.0f, 1.0f,
            0.5f, 0.5f, 0.0f,       0.0f, 0.0f, 1.0f, 1.0f,
            -0.5f, -0.5f, 0.0f,     1.0f, 1.0f, 0.0f, 1.0f
    };

    private int[] elementArray = {
            2, 1, 0,
            0, 1, 3
    };

    public Game() throws IOException {
        Shader vertexShader = new Shader(ShaderType.VERTEX, "assets/shaders/vertex.glsl");
        Shader fragmentShader = new Shader(ShaderType.FRAGMENT, "assets/shaders/fragment.glsl");

        shaderProgram = new ShaderProgram(vertexShader, fragmentShader);

        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertexArray.length);
        vertexBuffer.put(vertexArray).flip();

        IntBuffer elementBuffer = BufferUtils.createIntBuffer(elementArray.length);
        elementBuffer.put(elementArray).flip();

        vao = new VertexArrayObject();
        vbo = new VertexBufferObject(vertexBuffer);
        ebo = new ElementBufferObject(elementBuffer);

        int positionsSize = 3;
        int colorSize = 4;
        int floatSizeBytes = 4;
        int vertexSizeBytes = (positionsSize + colorSize) * floatSizeBytes;

        glVertexAttribPointer(0, positionsSize, GL_FLOAT, false, vertexSizeBytes, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, colorSize, GL_FLOAT, false, vertexSizeBytes, positionsSize * floatSizeBytes);
        glEnableVertexAttribArray(1);
    }

    public void update() {
        shaderProgram.use();
        vao.bind();

        glDrawElements(GL_TRIANGLES, elementArray.length, GL_UNSIGNED_INT, 0);

        vao.unbind();
        shaderProgram.detach();
    }
}
