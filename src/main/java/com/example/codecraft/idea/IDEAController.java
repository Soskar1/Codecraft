package com.example.codecraft.idea;

import game.Codecraft;

public class IDEAController {
    public void runGame() {
        Thread gameThread = new Thread(new Codecraft());
        gameThread.start();
    }
}