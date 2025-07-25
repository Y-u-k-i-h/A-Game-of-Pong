package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Window extends JFrame implements Runnable {

    Graphics2D g2d;
    Listener keyListener = new Listener();
    Paddle playerOnePaddle;
    Paddle playerTwoPaddle;
    Ball ball;

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
            0,
            (Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2),
            Constants.PADDLE_WIDTH,
            Constants.PADDLE_HEIGHT
            );
        playerTwoPaddle = new Paddle(
            (Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH),
            (Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2),
            Constants.PADDLE_WIDTH,
            Constants.PADDLE_HEIGHT
            );
        ball = new Ball(
            (Constants.SCREEN_WIDTH / 2 - Constants.BALL_DIAMETER / 2),
            (Constants.SCREEN_HEIGHT / 2 - Constants.BALL_DIAMETER / 2),
            Constants.BALL_DIAMETER
            );
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

        // W key moves the paddle up
        if (keyListener.isKeyPressed(KeyEvent.VK_W)) {
            System.out.println("W key pressed, moving paddle up");
            // TODO: Logic to move paddle up
        }

        // S key moves the paddle down
        if (keyListener.isKeyPressed(KeyEvent.VK_S)) {
            System.out.println("S key pressed, moving paddle down");
            // TODO: Logic to move paddle down
        }
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (!Thread.currentThread().isInterrupted()) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
