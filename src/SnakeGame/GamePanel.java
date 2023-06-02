package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.Random;

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final int []snakeXLength= new int[700];
    private final int []snakeYLength= new int[700];
    private int lengthOfSnake= 3;

    private final int []snakeXEnemyPosition={25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
            375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700,
            725, 750, 775, 800, 825, 850};
    private final int []snakeYEnemyPosition={75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
            375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};

    private final Random random= new Random();
    private int enemyXPosition, enemyYPosition;

    private boolean leftDirection= false;
    private boolean rightDirection= true;
    private boolean upDirection= false;
    private boolean downDirection= false;

    private int snakeMoves= 0;

    private int score= 0;

    private boolean gameOver= false;

    private final ImageIcon snakeTitileImageIcon= new ImageIcon(Objects.requireNonNull(getClass().getResource("SnakeGameTitle.png")));
    private final ImageIcon snakeLeftMouthImage= new ImageIcon(Objects.requireNonNull(getClass().getResource("SnakeLeftMouthImage.png")));
    private final ImageIcon snakeRightMouthImage= new ImageIcon(Objects.requireNonNull(getClass().getResource("SnakeRightMouthImage.png")));
    private final ImageIcon snakeUpMouthImage= new ImageIcon(Objects.requireNonNull(getClass().getResource("SnakeUpMouthImage.png")));
    private final ImageIcon snakeDownMouthImage= new ImageIcon(Objects.requireNonNull(getClass().getResource("SnakeDownMouthImage.png")));
    private final ImageIcon snakeBodyImage= new ImageIcon(Objects.requireNonNull(getClass().getResource("SnakeBodyImage.png")));
    private final ImageIcon snakeEnemyImageIcon= new ImageIcon(Objects.requireNonNull(getClass().getResource("SnakeEnemyImageIcon.png")));

    private final Timer timer;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        int delay = 150;
        timer= new Timer(delay, this);
        timer.start();

        newEnemy();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.drawRect(24, 10, 851, 55);
        g.drawRect(24, 74, 851, 576);

        snakeTitileImageIcon.paintIcon(this, g, 25, 11);
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        if(snakeMoves== 0){
            snakeXLength[0]= 100;
            snakeXLength[1]= 75;
            snakeXLength[2]= 50;

            snakeYLength[0]= 100;
            snakeYLength[1]= 100;
            snakeYLength[2]= 100;


        }
        if(leftDirection){
            snakeRightMouthImage.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
        }
        if(rightDirection){
            snakeLeftMouthImage.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
        }
        if(upDirection){
            snakeUpMouthImage.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
        }
        if(downDirection){
            snakeDownMouthImage.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
        }

        for(int i= 1; i< lengthOfSnake; i++){
            snakeBodyImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
        }

        snakeEnemyImageIcon.paintIcon(this, g, enemyXPosition, enemyYPosition);

        if(gameOver){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("GAME OVER", 300, 300);

            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to Continue", 320, 350);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Score :- "+ score, 750, 30);
        g.drawString("Length :- "+ lengthOfSnake, 750, 50);

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e){

        for(int i= lengthOfSnake- 1; i> 0; i--){
            snakeXLength[i]= snakeXLength[i- 1];
            snakeYLength[i]= snakeYLength[i- 1];
        }

        if(leftDirection){
            snakeXLength[0]= snakeXLength[0]- 25;
        }
        if(rightDirection){
            snakeXLength[0]= snakeXLength[0]+ 25;
        }
        if(upDirection){
            snakeYLength[0]= snakeYLength[0]- 25;
        }
        if(downDirection){
            snakeYLength[0]= snakeYLength[0]+ 25;
        }

        if(snakeXLength[0]> 850) snakeXLength[0]= 25;
        if(snakeXLength[0]< 25) snakeXLength[0]= 850;
        if(snakeYLength[0]> 625) snakeYLength[0]= 75;
        if(snakeYLength[0]< 75) snakeYLength[0]= 625;

        collidesWithEnemy();
        collidesWithSnakeBody();

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()== KeyEvent.VK_SPACE){
            restart();
        }

        if(e.getKeyCode()== KeyEvent.VK_LEFT && (!rightDirection)){
            leftDirection= true;
//            rightDirection= false;
            upDirection= false;
            downDirection= false;
            snakeMoves ++;
        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT && (!leftDirection)){
//            leftDirection= false;
            rightDirection= true;
            upDirection= false;
            downDirection= false;
            snakeMoves ++;
        }
        if(e.getKeyCode()== KeyEvent.VK_UP && (!downDirection)){
            leftDirection= false;
            rightDirection= false;
            upDirection= true;
//            downDirection= false;
            snakeMoves ++;
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN && (!upDirection)){
            leftDirection= false;
            rightDirection= false;
//            upDirection= false;
            downDirection= true;
            snakeMoves ++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void newEnemy() {
        enemyXPosition= snakeXEnemyPosition[random.nextInt(34)];
        enemyYPosition= snakeYEnemyPosition[random.nextInt(23)];
        for(int i= lengthOfSnake- 1; i>= 0; i--){
            if(snakeXLength[i]== enemyXPosition && snakeYLength[i]== enemyYPosition){
                newEnemy();
            }
        }
    }

    private void collidesWithEnemy() {
        if(snakeXLength[0]== enemyXPosition && snakeYLength[0]== enemyYPosition){
            newEnemy();
            lengthOfSnake= lengthOfSnake+ 1;
            score++;
        }
    }

    private void collidesWithSnakeBody() {
        for(int i= lengthOfSnake- 1; i> 0; i--){
            if(snakeXLength[i]== snakeXLength[0] && snakeYLength[i]== snakeYLength[0]){
                timer.stop();
                gameOver= true;
            }
        }
    }

    private void restart() {
        gameOver= false;
        snakeMoves= 0;
        score= 0;
        lengthOfSnake= 3;
        leftDirection= false;
        rightDirection= true;
        upDirection= false;
        downDirection= false;
        timer.start();
        repaint();

    }
}
