package example;

import javax.swing.*;

public class Window {
    private JButton pressButton;

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("HELLO");
        jFrame.setSize(300,300);
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
}
