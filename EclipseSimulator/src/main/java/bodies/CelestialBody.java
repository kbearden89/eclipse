package main.java.bodies;

import java.awt.Graphics;
import java.awt.Color;

public abstract class CelestialBody {
    // Attributes
    protected String name;
    protected double mass;
    protected double[] position; // Position as an array [x, y]
    protected double[] velocity; // Velocity as an array [vx, vy]
    protected Color color;       // Color to draw the object
    protected int size;
    private boolean isMovable;          // Size of the object for drawing

    // Constructor
    public CelestialBody(String name, double mass, double x, double y, Color color, int size) {
        this.name = name;
        this.mass = mass;
        this.position = new double[] {x, y};
        this.velocity = new double[] {0, 0}; // Initial velocity can be set to zero
        this.color = color;
        this.size = size;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double x, double y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double vx, double vy) {
        this.velocity[0] = vx;
        this.velocity[1] = vy;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public boolean isMovable() {
        return this.isMovable;
    }

    // Reverse update position for one time step
    public abstract void reverseUpdatePosition();

    protected void setMovable(boolean isMovable) {
        this.isMovable = isMovable;
    }

    // Method to draw the celestial body on the panel
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval((int)position[0] - size / 2, (int)position[1] - size / 2, size, size);
    }

    public abstract void updatePosition();
}
