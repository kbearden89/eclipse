package main.java.Simulator;
import javax.swing.JFrame;

import main.java.bodies.Earth;
import main.java.bodies.Moon;
import main.java.bodies.Sun;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Eclipse Simulator");
        Panel panel = new Panel();

        // Assuming the panel is 800x800 for demonstration purposes
        Sun sun = new Sun(1.989e30, 400, 400, Color.YELLOW, 50); // Mass of the Sun, central position, color, size
        panel.addBody(sun);
        Earth earth = new Earth(5.972e24, 400 + 150, 400, Color.BLUE, 20, 150); // Mass of Earth, initial position, color, size, orbital radius
        panel.addBody(earth);

        // Assuming Earth is already instantiated
        Moon moon = new Moon(7.342e22, Color.GRAY, 10, 50, earth); // mass, color, size, orbital radius, reference to earth
        panel.addBody(moon);

        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
