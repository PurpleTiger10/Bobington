package FIGHT.Entity;

import FIGHT.keyHandler;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import FIGHT.GamePanel;

public class player extends Entity{
    GamePanel gp;
    keyHandler keyH;
    int i;

    public player(GamePanel gp, keyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 0;
        y = 150;
        speed = 4;
        action = "idle";
    }

    public void getPlayerImage(){
        try{

            idle1 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/player/player0.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/player/player1.png"));

            punch1 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/player/playerPunchA0.png"));
            punch2 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/player/playerPunchA1.png"));
            punch3 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/player/playerPunchA2.png"));
            punch4 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/player/playerPunchA3.png"));
            punch5 = ImageIO.read(getClass().getResourceAsStream("/FIGHT/Animation/player/playerPunchA4.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.ePressed == true){
            action = "punch";
            System.out.println("You pressed E!");
//            x+=100;
//            y+=100;
            keyH.ePressed = false;
        }
        if (keyH.qPressed == true){
            action = "block";
            System.out.println("You pressed Q!");
//            x-=10;
//            y-=10;
            keyH.qPressed = false;
        }
         spriteCounter++;
        if (spriteCounter > 5) {
            spriteCounter = 0;
            spriteNum++;

            if (action.equals("idle") && spriteNum > 2)
                spriteNum = 1;

            if (action.equals("punch") && spriteNum > 5) {
                spriteNum = 1;
                action = "idle";
            }

            if (action.equals("block") && spriteNum > 2) {
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
                break;
            case "block":
                image = punch2;
                break;
        }

        g2.drawImage(image, x, y, 300, 300, null);
    }
}
