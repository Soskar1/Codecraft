package game;

import game.engine.Time;
import game.engine.Window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.opengl.GL11.*;

public class Codecraft implements Runnable {
    private Window window;

    @Override
    public void run() {
        window = Window.get();
        Game game = new Game();

        float beginTime = Time.getTime();
        float endTime;

        while (window.isOpened()) {
            glfwPollEvents();

            glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            if (Time.deltaTime >= 0) {
                game.update();
            }

            window.swapBuffers();

            endTime = Time.getTime();
            Time.deltaTime = endTime - beginTime;
            beginTime = endTime;
        }

        window.free();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}