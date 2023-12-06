package game.engine.gfx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL20.*;

public class Shader {
    private int id;

    public Shader(ShaderType shaderType, String shaderPath) throws IOException {
        id = glCreateShader(shaderType.toGL());

        String source = new String(Files.readAllBytes(Paths.get(shaderPath)));
        glShaderSource(id, source);
        glCompileShader(id);

        int success = glGetShaderi(id, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(id, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: Shader " + shaderPath + " compilation failed");
            System.out.println(glGetShaderInfoLog(id, len));
            assert false : "";
        }
    }

    public int getShader() {
        return id;
    }
}
