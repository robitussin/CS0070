package basicexample;

import javax.swing.JFrame;

public class HelloSwing {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello Swing");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}