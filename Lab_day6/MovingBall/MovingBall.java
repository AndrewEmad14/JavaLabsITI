package Lab_day6.MovingBall;

import javax.swing.*;
import java.awt.*;

public class MovingBall extends JFrame {
    int xPosition = 0;
    int yPosition = 0;
    int xDirection = 1;
    int yDirection = 1;
    private int height = 1000;
    private int width = 1000;
    private JLabel label;

    MovingBall() {
        setTitle("Display Image");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Load image
        String imagePath = "/Users/andrewemad/Documents/JavaLabsITI/Lab_day6/MovingBall/Ball.png";
        ImageIcon icon = new ImageIcon(imagePath);
        label = new JLabel(icon);
        label.setSize(label.getPreferredSize()); // Set label size
        label.setLocation(xPosition, height / 2); // Start position
        label.setOpaque(false);

        add(label);
        setVisible(true);
        startBounce();

    }

    private void startBounce() {
        // Simple bounce logic can be implemented here
        Timer timer = new Timer(20, e -> {
            // Move label
            xPosition += xDirection * 5; // Speed: 2 pixels per tick
            yPosition += yDirection * 5;
            if (xPosition >= getWidth() - label.getWidth()) {
                xPosition = getWidth() - label.getWidth();
                xDirection = -1;
            } else if (xPosition <= 0) {
                xPosition = 0;
                xDirection = 1;
            }
            if (yPosition >= getHeight() - label.getHeight()) {
                yPosition = getHeight() - label.getHeight();
                yDirection = -1;
            } else if (yPosition <= 0) {
                yPosition = 0;
                yDirection = 1;
            }
            label.setLocation(xPosition, yPosition);

        });
        timer.start();
        ;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovingBall());
    }
}
