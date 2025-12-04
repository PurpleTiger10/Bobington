package FIGHT;
import java.awt.Color;
import javax.swing.JPanel;

import FIGHT.Entity.player;
import FIGHT.Enemy.enemy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    final double MAX_SCREEN_COL = 6.25;
    final double MAX_SCREEN_ROW = 9.375;
    final int SCREEN_WIDTH = (int)(TILE_SIZE*MAX_SCREEN_COL);
    final int SCREEN_HEIGHT = (int)(TILE_SIZE*MAX_SCREEN_ROW);
    int playerX = 100;
    int playerY = 100;
    int FPS = 30;

    boolean punching = false;

    keyHandler keyH;
    Thread gameThread;
    enemy bubby = new enemy(this);
    player fighter;

    public GamePanel(){
        this.keyH = new keyHandler();
        this.fighter = new player(this, keyH);
        this.setPreferredSize(new Dimension (SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.decode("#00cccc"));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null){


            //TODO: UPDATE
            update();
            //TODO: DRAW
            repaint();

            try{
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime /= 1000000;

            if (remainingTime < 0){
                remainingTime = 0;
            }

            Thread.sleep((long)remainingTime);

            nextDrawTime += drawInterval;
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        bubby.update();
        fighter.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        bubby.draw(g2);
        fighter.draw(g2);
        g2.dispose();
    }
}