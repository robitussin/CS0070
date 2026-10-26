package eventlistener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonDemo extends JFrame implements ActionListener {

    JButton redButton = new JButton("Red");
    JButton blueButton = new JButton("Blue");
    JButton greenButton = new JButton("Green");

    JPanel panel = new JPanel();

    public ColorButtonDemo() {
        setTitle("Color Button Demo");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Add event listeners to each button
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Add buttons to the window
        add(redButton);
        add(blueButton);
        add(greenButton);

        // Panel whose color will change
        panel.setPreferredSize(new Dimension(350, 120));
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Check which button was clicked
        if (e.getSource() == redButton) {
            panel.setBackground(Color.RED);

        } else if (e.getSource() == blueButton) {
            panel.setBackground(Color.BLUE);

        } else if (e.getSource() == greenButton) {
            panel.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new ColorButtonDemo();
    }
}