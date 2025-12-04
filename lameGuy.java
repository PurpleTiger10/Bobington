
import FIGHT.GamePanel;
import FIGHT.keyHandler;

public class lameGuy{
    private Bobington game;
    public keyHandler keyH;
    public lameGuy(Bobington game, keyHandler keyH, GamePanel panel) {
        this.game = game;
        this.keyH = keyH;
        this.panel = new GamePanel();
    }
    //startFight sf = new startFight(game);
    GamePanel panel = new GamePanel();

    public void fight(){
    FIGHT.fight fighting = new FIGHT.fight();
    game.drawingPanel.add(fighting.getPanel(), java.awt.BorderLayout.CENTER);
    fighting.start();
    }

    public void home(){
    game.mainTextArea.setText("Your in your house cause you are a sad little twit");
    game.choiceButtonPanel.remove(game.choice3);
    game.choice1.setText("Take a nap");
    game.choice2.setText("Scroll reels");
    
    game.nextPosition1 = "nap";
    game.nextPosition2 = "scroll";
    }
public void nap(){
    game.mainTextArea.setText("You are a wee bit sleepy and so you go to bed.");
    game.choice1.setText("what");
    game.choice2.setText("to do?");
    game.con.repaint();
    game.con.revalidate();
    }
    public void scroll(){
    game.mainTextArea.setText("People come to door");
    game.choice1.setText("Join the Bob Army");
    game.choice2.setText("Please shut up with this Bob stuff");
    game.nextPosition1 = "fakeBob";
    game.nextPosition2 = "blorbSpies";
    game.con.repaint();
    game.con.revalidate();
    }
    public void fakeBob(){
        game.mainTextArea.setText("We not bob");
        fight();
        //sf.fight();
        game.con.revalidate();
        game.con.repaint();
    }
    public void blorbSpies(){
        game.mainTextArea.setText("Join the Blorb army?");
        game.choice1.setText("Join the Blorb army");
        game.choice2.setText("No thanks. Just let me scroll");
        game.con.repaint();
        game.con.revalidate();
    }
}