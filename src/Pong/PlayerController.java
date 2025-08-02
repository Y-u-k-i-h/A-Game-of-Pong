package Pong;

import java.awt.event.KeyEvent;

public class PlayerController {
    private Paddle paddle;
    private Listener keyListener;

    public PlayerController(Paddle paddle, Listener keyListener) {
        this.paddle = paddle;
        this.keyListener = keyListener;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_S)) {
            this.paddle.setY((this.paddle.getY() + (100 * dt)));
        }
    }
}
