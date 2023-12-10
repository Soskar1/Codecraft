package com.example.codecraft.game;

import org.python.core.PyFunction;

import java.io.IOException;
import java.util.Hashtable;

import static com.raylib.Raylib.*;

public class KeyListener {
    private static final Hashtable<Integer, Action> registeredButtons = new Hashtable<>();

    private static void setAction(int button, Action action) {
        registeredButtons.put(button, action);
    }

    public static void setAction(KeyCode keyCode, PyFunction pyFunction) throws Exception {
        int button = getRaylibKeyCode(keyCode);
        setAction(button, pyFunction::__call__);
    }

    private static int getRaylibKeyCode(KeyCode keyCode) {
        return switch (keyCode) {
            case LEFT_MOUSE_CLICK -> MOUSE_BUTTON_LEFT;
            case RIGHT_MOUSE_CLICK -> MOUSE_BUTTON_RIGHT;
            case Q -> KEY_Q;
            case W -> KEY_W;
            case E -> KEY_E;
            case R -> KEY_R;
            case T -> KEY_T;
            case Y -> KEY_Y;
            case U -> KEY_U;
            case I -> KEY_I;
            case O -> KEY_O;
            case P -> KEY_P;
            case A -> KEY_A;
            case S -> KEY_S;
            case D -> KEY_D;
            case F -> KEY_F;
            case G -> KEY_G;
            case H -> KEY_H;
            case J -> KEY_J;
            case K -> KEY_K;
            case L -> KEY_L;
            case Z -> KEY_Z;
            case X -> KEY_X;
            case C -> KEY_C;
            case V -> KEY_V;
            case B -> KEY_B;
            case N -> KEY_N;
            case M -> KEY_M;
        };
    }

    public static void listen() {
        var keyIterator = registeredButtons.keys().asIterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();

            if (key <= 1 && IsMouseButtonPressed(key)) //Mouse input
                registeredButtons.get(key).execute();
            else if (IsKeyDown(key)) // Keyboard input
                registeredButtons.get(key).execute();
        }
    }
}
