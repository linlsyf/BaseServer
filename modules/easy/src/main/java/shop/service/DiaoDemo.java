package shop.service;

import javax.swing.*;
import java.awt.*;

public class DiaoDemo {

    public  static void main(String s[]){
        JFrame frame=new JFrame("test");
        JButton button=new JButton("PRESS");
        frame.getContentPane().add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
