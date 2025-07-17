package Pong;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame implements Runnable {

    Graphics2D g2d;

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(Constants.RESIZABLE);
        this.setVisible(Constants.VISIBLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g2d = (Graphics2D) this.getGraphics();
    }

    public void update(double dt) {
        System.out.println("Seconds passed since last frame: " + dt);
        System.out.println("FPS: " + (1.0 / dt));

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
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
