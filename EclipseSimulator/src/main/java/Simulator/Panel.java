package main.java.Simulator;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;

import main.java.bodies.CelestialBody;

import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel implements ActionListener {
    private List<CelestialBody> bodies; // List to hold all celestial bodies
    private Timer timer; // Timer for controlling animation
    private JButton pauseButton, playButton, stepForwardButton, stepBackwardButton;
    private JLabel dayCounterLabel;
    private int dayCount = 0; // Counter for the days
    private boolean isMovingForward = true; // Flag to control the direction of simulation

    public Panel() {
        bodies = new ArrayList<>();
        initTimer();
        initControls();
        initDayCounter();
    }

    private void initTimer() {
        timer = new Timer(100, this); // The timer fires every 100 milliseconds
        timer.start();
    }

    private void initControls() {
        pauseButton = new JButton("Pause");
        playButton = new JButton("Play");
        stepForwardButton = new JButton("Step Forward");
        stepBackwardButton = new JButton("Step Backward");

        pauseButton.addActionListener(e -> timer.stop());
        playButton.addActionListener(e -> timer.start());
        stepForwardButton.addActionListener(e -> stepDay(true));
        stepBackwardButton.addActionListener(e -> stepDay(false));

        this.add(pauseButton);
        this.add(playButton);
        this.add(stepForwardButton);
        this.add(stepBackwardButton);
    }

    private void initDayCounter() {
        dayCounterLabel = new JLabel("Day: " + dayCount);
        this.add(dayCounterLabel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updatePositions();
        repaint();
        updateDayCounter();
    }

    private void updateDayCounter() {
        if (isMovingForward) {
            dayCount++;
        } else {
            dayCount--;
        }
        dayCounterLabel.setText("Day: " + dayCount);
    }

    private void stepDay(boolean forward) {
        isMovingForward = forward;
        updatePositions();
        repaint();
        updateDayCounter();
    }

    private void updatePositions() {
        for (CelestialBody body : bodies) {
            if (body.isMovable()) {
                if (isMovingForward) {
                    body.updatePosition();
                } else {
                    body.reverseUpdatePosition();
                }
            }
        }
    }

    public void addBody(CelestialBody body) {
        bodies.add(body);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CelestialBody body : bodies) {
            body.draw(g);
        }
    }
}
