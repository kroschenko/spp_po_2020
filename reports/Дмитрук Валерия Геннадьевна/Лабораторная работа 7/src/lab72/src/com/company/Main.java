package com.company;

import java.awt.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minkowski");
        JTextField textField = new JTextField(15);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setSize(screenSize);

        DrawPanel panel = new DrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.add(textField);

        JButton button = new JButton("Send iterator");
        frame.add(button);
        frame.setVisible(true);
        button.addActionListener(e -> {
            panel.setIterations(Integer.parseInt(textField.getText()));
            frame.setContentPane(panel);
            });
    }
}