package Lab_day6.MarqeeTextProject;

import javax.swing.*;
import java.awt.*;

public class MarqeeText extends JFrame {
    private JLabel label;
    private int xPosition = 0;
    private String marqueeString = "Java World ";

    public MarqeeText() {
        int height = 300, width = 600;

        // Set up the frame
        setTitle("Marquee Text");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use absolute positioning for smooth animation

        // Create label
        label = new JLabel(marqueeString);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setSize(label.getPreferredSize()); // Set label size
        label.setLocation(xPosition, height / 2); // Start position

        add(label);
        setVisible(true);

        // Start animation in a separate thread
        startMarquee();
    }

    private void startMarquee() {

        Timer timer = new Timer(20, e -> {
            // Move label
            xPosition += 2; // Speed: 2 pixels per tick
            if (xPosition > getWidth()) {
                xPosition = -label.getWidth();
            }

            label.setLocation(xPosition, label.getY());

        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MarqeeText());
    }
}