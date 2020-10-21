package live.ilyusha.spp7.task2;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter iterations: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Choose color: [1] red, [2] cyan, [3] pink, [4] blue");
        int c = sc.nextInt();
        Color[] color = { Color.RED, Color.CYAN, Color.MAGENTA, Color.BLUE };
        
        JFrame window = new JFrame("Levy");
        window.setSize(615, 605);
        window.setContentPane(new LevyPanel(n, color[c - 1]));
        window.setResizable(false);
        window.setVisible(true);
    }

}