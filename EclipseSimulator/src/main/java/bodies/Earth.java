package main.java.bodies;


import java.awt.Color;

public class Earth extends CelestialBody {
    private double orbitalRadius; // Distance from the Sun
    private double angle;         // Current angle in the orbit in degrees
    private final double orbitalCenterX = 400;
    private final double orbitalCenterY = 400;

    public Earth(double mass, double x, double y, Color color, int size, double orbitalRadius) {
        super("Earth", mass, x, y, color, size);
        this.orbitalRadius = orbitalRadius;
        this.angle = 0; // Start at angle 0
        setMovable(true);
    }

    @Override
    public void updatePosition() {
        angle += 360.0 / 365; // Move forward by one day's worth of angle
        if (angle >= 360) angle -= 360;
        updateOrbit();
    }

    @Override
    public void reverseUpdatePosition() {
        angle -= 360.0 / 365; // Move backward by one day's worth of angle
        if (angle < 0) angle += 360;
        updateOrbit();
    }

    private void updateOrbit() {
        double radians = Math.toRadians(angle);
        position[0] = orbitalCenterX + orbitalRadius * Math.cos(radians);
        position[1] = orbitalCenterY + orbitalRadius * Math.sin(radians);
    }
}
