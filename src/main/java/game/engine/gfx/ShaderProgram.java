package game.engine.gfx;

import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram {
    private int id;

    public ShaderProgram(Shader vertexShader, Shader fragmentShader) {
        id = glCreateProgram();
        glAttachShader(id, vertexShader.getShader());
        glAttachShader(id, fragmentShader.getShader());
        glLinkProgram(id);

        int success = glGetProgrami(id, GL_LINK_STATUS);
        if (success == GL_FALSE) {
            int len = glGetProgrami(id, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: Linking of shaders failed");
            System.out.println(glGetProgramInfoLog(id, len));
            assert false : "";
        }
    }

    public int getId() {
        return id;
    }

    public void use() {
        glUseProgram(id);
    }

    public void detach() {
        glUseProgram(0);
    }
}
