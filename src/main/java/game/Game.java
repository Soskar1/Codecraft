package game;

import game.engine.Window;

public class Game {
    public static void main(String[] args) {
        Window window = Window.get();
        window.run();
    }

    public void start() {
        Window window = Window.get();
        window.run();
    }
}
