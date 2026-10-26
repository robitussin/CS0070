package eventlistener;

import javax.swing.*;
import java.awt.*;

public class ColorButtonLambdaDemo extends JFrame {

    JButton redButton = new JButton("Red");
    JButton blueButton = new JButton("Blue");
    JButton greenButton = new JButton("Green");

    JPanel panel = new JPanel();

    public ColorButtonLambdaDemo() {
        setTitle("Color Button Lambda Demo");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        panel.setPreferredSize(new Dimension(350, 120));
        panel.setBackground(Color.LIGHT_GRAY);

        // Lambda event listeners
        redButton.addActionListener(e -> panel.setBackground(Color.RED));
        blueButton.addActionListener(e -> panel.setBackground(Color.BLUE));
        greenButton.addActionListener(e -> panel.setBackground(Color.GREEN));

        add(redButton);
        add(blueButton);
        add(greenButton);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorButtonLambdaDemo();
    }
}