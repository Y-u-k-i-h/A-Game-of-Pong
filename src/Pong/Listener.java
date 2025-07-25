package Pong;

import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    // Array to keep track of key states
    private final boolean[] keyPressed = new boolean[128];

    @Override
    public void keyTyped(java.awt.event.KeyEvent keyEvent) {
        // Handle key typed event
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode >= 0 && keyCode < keyPressed.length) {
            keyPressed[keyCode] = true;
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent keyEvent) {
        keyPressed[keyEvent.getKeyCode()] = false;
    }

    // Method to check if a key is currently pressed
    // Returns true if the key(keycode) is pressed, false otherwise
    public boolean isKeyPressed(int keycode) {
        return keyPressed[keycode];
    }
}
