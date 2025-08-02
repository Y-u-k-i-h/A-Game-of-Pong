package Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Paddle {
    // Paddle position
    private double x, y;

    // Paddle dimensions and Color
    private final double width, height;
    private Color paddleColor;

    public Paddle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.paddleColor = Constants.PADDLE_COLOR; // Default color for the paddle
    }

    public Paddle(double x, double y, double width, double height, Color paddleColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.paddleColor = paddleColor;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(paddleColor);
        g2d.fill(new Rectangle2D.Double(x, y, width, height));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }
}
