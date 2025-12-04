package FIGHT;

import java.awt.event.KeyListener; 
import java.awt.event.KeyEvent; 
public class keyHandler implements KeyListener{ 
    public boolean ePressed, qPressed; 
    @Override 
    public void keyTyped(KeyEvent e){}
    @Override 
    public void keyPressed(KeyEvent e){
             int code = e.getKeyCode(); 
        if(code == KeyEvent.VK_E){ 
            ePressed = true; 
        }
        if(code == KeyEvent.VK_Q){
             qPressed = true;
        } 
    } 
    @Override 
    public void keyReleased(KeyEvent e){
             int code = e.getKeyCode(); 
        if(code == KeyEvent.VK_E){ 
            ePressed = false; 
        }
        if(code == KeyEvent.VK_Q){
             qPressed = false;
        } 
    }  
    }