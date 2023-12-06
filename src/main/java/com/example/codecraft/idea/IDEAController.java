package com.example.codecraft.idea;

import game.Game;

public class IDEAController {
    public void runGame() {
        Thread gameThread = new Thread(new Game());
        gameThread.start();
    }
}