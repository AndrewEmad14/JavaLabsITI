package Lab_day6.TimeAndDateProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeAndDate extends JFrame {

    private JLabel label;
    private JTextField textField;
    private JButton button;

    public String currentTime() {
        ZonedDateTime now = ZonedDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

        String formatted = now.format(formatter);
        System.out.println(formatted);
        return formatted;
    }

    public TimeAndDate() {
        // Set up the frame
        setTitle("My Swing App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // allows vertical and horizontal alignment

        // Create components

        label = new JLabel("Current Time: " + currentTime());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        // Add components to frame
        add(label);

        // Make visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimeAndDate());
    }
}