package com.example.codecraft.game;

import org.python.core.PyFunction;

import java.util.Hashtable;

import static com.raylib.Raylib.*;

public class KeyListener {
    private static final Hashtable<Integer, Action> registeredButtons = new Hashtable<>();

    private static void setAction(int button, Action action) {
        registeredButtons.put(button, action);
    }

    public static void setAction(KeyCode keyCode, PyFunction pyFunction) throws Exception {
        int button;

        switch (keyCode) {
            case A -> button = KEY_A;
            case S -> button = KEY_S;
            case D -> button = KEY_D;
            case W -> button = KEY_W;
            default -> throw new Exception("Key does not exist!");
        }

        setAction(button, pyFunction::__call__);
    }

    public static void listen() {
        var keyIterator = registeredButtons.keys().asIterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();

            if (IsKeyDown(key)) {
                registeredButtons.get(key).execute();
            }
        }
    }
}
