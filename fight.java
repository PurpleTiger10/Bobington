/*A huge shoutout to RyiSnow's tutorials for helping me make this entire game. He has two serieses, one on text based
adventure, and another on 2D games, so if you are looking to make something like that, definately check him out!!! */
package FIGHT;
//import javax.swing.JFrame;

public class fight{
    private GamePanel panel;

    public fight(){
        panel = new GamePanel();
    }

    public GamePanel getPanel(){
        return panel;
    }

    public void start(){
        panel.startGameThread();
    }
    /* 
    public static void main(String []args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(300,450);
        GamePanel panel = new GamePanel();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.startGameThread();

    }
    */
}
