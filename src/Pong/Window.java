package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Window extends JFrame implements Runnable {

    private Graphics2D g2d;
    private Listener keyListener = new Listener();
    private Paddle playerOnePaddle;
    private Paddle playerTwoPaddle;
    private Ball ball;
    private PlayerController playerOneController;
    private PlayerController playerTwoController;

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(Constants.RESIZABLE);
        this.setLocationRelativeTo(null);
        this.setVisible(Constants.VISIBLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2d = (Graphics2D) this.getGraphics();

        // Draw paddles and ball
        playerOnePaddle = new Paddle(
            Constants.HORIZONTAL_PADDING,
            ((double) Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2),
            Constants.PADDLE_WIDTH,
            Constants.PADDLE_HEIGHT
            );
        playerTwoPaddle = new Paddle(
            (Constants.SCREEN_WIDTH - Constants.HORIZONTAL_PADDING - Constants.PADDLE_WIDTH),
            ((double) Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2),
            Constants.PADDLE_WIDTH,
            Constants.PADDLE_HEIGHT
            );
        ball = new Ball(
            ((double) Constants.SCREEN_WIDTH / 2 - Constants.BALL_DIAMETER / 2),
            ((double) Constants.SCREEN_HEIGHT / 2 - Constants.BALL_DIAMETER / 2),
            Constants.BALL_DIAMETER
            );

        playerOneController = new PlayerController(playerOnePaddle, keyListener);
    }

    public void update(double dt) {
        /*
        System.out.println("Seconds passed since last frame: " + dt);
        System.out.println("FPS: " + (1.0 / dt));
        */

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        playerOnePaddle.draw(g2d);
        playerTwoPaddle.draw(g2d);
        ball.draw(g2d);

        // Escape key closes the window
        if (keyListener.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            System.out.println("Escape pressed, Closing window...");
            this.dispose();
            System.exit(0);
        }

        playerOneController.update(dt);

    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (!Thread.currentThread().isInterrupted()) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

        }
    }

    public Graphics2D getGraphics2D() {
        if (g2d != null) {
            return g2d;
        } else {
            System.out.println("Graphics2D is not initialized.");
            return null;
        }
    }

    public Listener getKeyListener() {
        return keyListener;
    }

    public Paddle getPlayerOnePaddle() {
        return playerOnePaddle;
    }

    public Paddle getPlayerTwoPaddle() {
        return playerTwoPaddle;
    }

    public Ball getBall() {
        return ball;
    }
}
