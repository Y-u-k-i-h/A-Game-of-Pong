package Pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Paddle {
    // Paddle position
    private int x, y;

    // Paddle dimensions and Color
    private final int width, height;
    private Color paddleColor;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.paddleColor = Constants.PADDLE_COLOR; // Default color for the paddle
    }

    public Paddle(int x, int y, int width, int height, Color paddleColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.paddleColor = paddleColor;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(paddleColor);
        g2d.fillRect(x, y, width, height);
    }
}
