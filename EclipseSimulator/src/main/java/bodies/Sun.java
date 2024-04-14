package main.java.bodies;
import java.awt.Color;

public class Sun extends CelestialBody {
    // Constructor
    public Sun(double mass, double x, double y, Color color, int size) {
        super("Sun", mass, x, y, color, size);
        setMovable(false);
    }
    public void updatePosition() {
        // The Sun does not move, so this method does not need to do anything.
    }
    // Override setPosition to prevent the Sun from moving
    @Override
    public void setPosition(double x, double y) {
        // Since the Sun is stationary, we do not update its position.
    }

    // The Sun does not need to update its velocity
    @Override
    public void setVelocity(double vx, double vy) {
        // The Sun does not move, so its velocity remains zero.
    }
    public void reverseUpdatePosition() {
        
    }
}
