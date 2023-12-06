package game.engine;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.Callbacks.*;

public class Window {
    private int width = 1280;
    private int height = 720;
    private String title = "Codecraft";
    private long glfwWindow;

    private static Window window = null;

    private Window() {
        init();
    }

    public static Window get() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    private void init() {
        // Setup an error callback
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_FALSE);

        //Create the window
        glfwWindow = glfwCreateWindow(width, height, title, NULL, NULL);

        if (glfwWindow == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window.");
        }

        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);
        glfwSetKeyCallback(glfwWindow, KeyListener::keyCallback);

        //Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        //Enable v-sync
        glfwSwapInterval(1);

        //Make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();
    }

    public void free() {
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);
    }

    public boolean isOpened() {
        return !glfwWindowShouldClose(glfwWindow);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void swapBuffers() {
        glfwSwapBuffers(glfwWindow);
    }
}
