package basicexample;

import javax.swing.*;
import java.awt.*;

public class FramePanelDemo {

    public static void main(String[] args) {

        // JFrame = the main application window
        JFrame frame = new JFrame("JFrame and JPanel Demo");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel = a container placed inside the JFrame
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        // Components are added to the JPanel
        JLabel label = new JLabel("Welcome to Java Swing!");
        JButton button = new JButton("Click Me");

        panel.add(label);
        panel.add(button);

        // The JPanel is added to the JFrame
        frame.add(panel);

        // Show the window
        frame.setVisible(true);
    }
}