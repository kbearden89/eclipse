package main.java.bodies;

import java.awt.Color;

public class Moon extends CelestialBody {
    private double orbitalRadius; // Distance from Earth
    private double angle;         // Current angle in the orbit in degrees
    private CelestialBody earth; 
     // Reference to Earth for relative positioning

    public Moon(double mass, Color color, int size, double orbitalRadius, CelestialBody earth) {
        super("Moon", mass, earth.getPosition()[0] + orbitalRadius, earth.getPosition()[1], color, size);
        this.orbitalRadius = orbitalRadius;
        this.angle = 0; // Start at angle 0
        this.earth = earth; // Maintain a reference to Earth for relative positioning
        setMovable(true);
    }

    @Override
    public void updatePosition() {
        angle += 360.0 / 27; // Increment the angle by the degrees per day
        if (angle >= 360) {
            angle -= 360; // Reset the angle after completing the orbit
        }
        updateOrbit();
    }

    @Override
    public void reverseUpdatePosition() {
        angle -= 360.0 / 27; // Decrement the angle by the degrees per day
        if (angle < 0) {
            angle += 360; // Reset the angle after a full negative rotation
        }
        updateOrbit();
    }

    private void updateOrbit() {
        double radians = Math.toRadians(angle);
        position[0] = earth.getPosition()[0] + orbitalRadius * Math.cos(radians);
        position[1] = earth.getPosition()[1] + orbitalRadius * Math.sin(radians);
    }
}
