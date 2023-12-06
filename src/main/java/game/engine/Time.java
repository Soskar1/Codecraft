package game.engine;

public class Time {
    public static long timeStarted = System.nanoTime();
    public static float deltaTime = -1.0f;

    public static float getTime() {
        return (float)((System.nanoTime() - timeStarted) * 1E-9);
    }
}
