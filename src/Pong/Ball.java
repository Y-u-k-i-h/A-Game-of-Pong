package Pong;

import java.awt.Color;
import  java.awt.Graphics2D;

public class Ball {
    // Ball position
    private int x, y;

    // Ball dimensions and Color
    private final int diameter;
    private Color ballColor;

    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.ballColor = Constants.BALL_COLOR; // Default color for the ball
    }

    public Ball(int x, int y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.ballColor = color;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(ballColor);
        g2d.fillOval(x, y, diameter, diameter);
    }
}
