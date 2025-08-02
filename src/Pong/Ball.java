package Pong;

import java.awt.Color;
import  java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball {
    // Ball position
    private double x, y;

    // Ball dimensions and Color
    private final double diameter;
    private Color ballColor;

    public Ball(double x, double y, double diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.ballColor = Constants.BALL_COLOR; // Default color for the ball
    }

    public Ball(double x, double y, double diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.ballColor = color;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(ballColor);
        g2d.fill(new Ellipse2D.Double(x, y, diameter, diameter));
    }
}
