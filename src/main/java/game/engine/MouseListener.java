package game.engine;

import static org.lwjgl.glfw.GLFW.*;

public class MouseListener {
    private static MouseListener instance;
    private double scrollX = 0.0;
    private double scrollY = 0.0;
    private double xPos = 0.0;
    private double yPos = 0.0;
    private double lastX = 0.0;
    private double lastY = 0.0;
    private boolean mouseButtonPressed[] = new boolean[3];
    private boolean isDragging;

    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }

        return MouseListener.instance;
    }

    public static void mousePosCallback(long window, double xPos, double yPos) {
        get();
        get().lastX = get().xPos;
        get().lastY = get().yPos;
        get().xPos = xPos;
        get().yPos = yPos;
        get().isDragging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2];
    }

    public static void mouseButtonCallback(long window, int button, int action, int mods) {
        get();
        if (button < get().mouseButtonPressed.length) {
            if (action == GLFW_PRESS) {
                get().mouseButtonPressed[button] = true;
            } else if (action == GLFW_RELEASE) {
                get().mouseButtonPressed[button] = false;
                get().isDragging = false;
            }
        }
    }

    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {
        get().scrollX = xOffset;
        get().scrollY = yOffset;
    }

    public static void endFrame() {
        get().scrollX = 0;
        get().scrollY = 0;
        get().lastX = get().xPos;
        get().lastY = get().yPos;
    }

    public static double getX() {
        return get().xPos;
    }

    public static double getY() {
        return get().yPos;
    }

    public static double getDx() {
        return get().lastX - get().xPos;
    }

    public static double getDy() {
        return get().lastY - get().yPos;
    }

    public static double getScrollX() {
        return get().scrollX;
    }

    public static double getScrollY() {
        return get().scrollY;
    }

    public static boolean isDragging() {
        return isDragging();
    }

    public static boolean mouseButtonDown(int button) {
        if (button < get().mouseButtonPressed.length) {
            return false;
        }

        return get().mouseButtonPressed[button];
    }
}
