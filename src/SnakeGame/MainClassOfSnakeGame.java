package SnakeGame;

import java.awt.*;
import javax.swing.*;
public class MainClassOfSnakeGame {
    //Here it is my Constructor of MainClassOfSnakeGame.
    public MainClassOfSnakeGame() {
        JFrame jFrame= new JFrame("RitikCoder's Snake Game-1.0");
        jFrame.setBounds(300, 100, 905, 700);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GamePanel gamePanel= new GamePanel();
        gamePanel.setBackground(Color.DARK_GRAY);
        jFrame.add(gamePanel);

        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        MainClassOfSnakeGame mainClassOfSnakeGame= new MainClassOfSnakeGame();
    }
}
