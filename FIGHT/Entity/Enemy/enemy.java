package FIGHT.Enemy;

import FIGHT.GamePanel;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


import javax.imageio.ImageIO;

public class enemy extends EntityEnemy{
    GamePanel gp;
    int i;
    int idleDelay = 15;
    int punchDelay = 3;
    Random rand = new Random();

    public enemy(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
        getEnemyImage();
    }

    public void setDefaultValues(){
        x = -200;
        y = -100;
        action = "idle";
    }

    public void getEnemyImage(){
        try{

            idle1 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/Bubby0.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/Bubby1.png"));

            punch1 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA0.png"));
            punch2 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA1.png"));
            punch3 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA2.png"));
            punch4 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA3.png"));
            punch5 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA4.png"));
            punch6 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA5.png"));
            punch7 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA6.png"));
            punch8 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA7.png"));
            punch9 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA8.png"));
            punch10 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/bubby/BubbyPunchA9.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (rand.nextInt(100) == 0){
            action = "punch";
            spriteCounter = 0;
            spriteNum = 1;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }
         spriteCounter++;
       
        int currentDelay = action.equals("punch") ? punchDelay : idleDelay;

        if (spriteCounter > currentDelay) {
            spriteCounter = 0;
            spriteNum++;

            if (action.equals("idle") && spriteNum > 2)
                spriteNum = 1;

            if (action.equals("punch") && spriteNum > 10) {
                spriteNum = 1;
                action = "idle";
            }
        }
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.decode("#341d58"));
//        g2.fillRect(x, x, gp.TILE_SIZE, gp.TILE_SIZE);
        BufferedImage image = null;

        switch(action){
            case "idle":
                image = (spriteNum == 1) ? idle1 : idle2;
                break;
            case "punch":
                if (spriteNum == 1) image = punch1;
                if (spriteNum == 2) image = punch2;
                if (spriteNum == 3) image = punch3;
                if (spriteNum == 4) image = punch4;
                if (spriteNum == 5) image = punch5;
                if (spriteNum == 6) image = punch6;
                if (spriteNum == 7) image = punch7;
                if (spriteNum == 8) image = punch8;
                if (spriteNum == 9) image = punch9;
                if (spriteNum == 10) image = punch10;
                break;
        }

        g2.drawImage(image, x, y, 750, 750, null);
    }
}
