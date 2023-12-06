package game;

import game.engine.Window;

    public class Game implements Runnable {
        private Window window;

        @Override
        public void run() {
            window = Window.get();
            window.run();
        }
    }
