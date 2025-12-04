
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
    game.mainTextArea.setText("\"Nah, I'm good\" you say. You leave the station and head home, because you are a sad little "+
    "coward who won't stand up for what you know is truely right. As you get home, you see your couch and TV calling your name.");
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
    game.mainTextArea.setText("You plop onto the couch, hook up your phone to the TV, and start scrolling reels. What a shame you "+
        "are to society. About 30 minutes in, a knock comes at the door.");
    game.choice1.setText("Answer the door");
    game.choice2.setText("Ignore it");
    game.nextPosition1 = "scroll2";
    game.nextPosition2 = "nap";
    }
    public void scroll2(){
    game.mainTextArea.setText("\"Hello? Who is it?\" You ask. \"Hello there, we are with the Bob army-\" \"Listen pal, "+
    "I've already heard the thing.\" You interrupt. \"Alright, well, would you like to join us?\" the solicitor asks. ");
    game.choice1.setText("Join the Bob Army");
    game.choice2.setText("Please shut up with this Bob stuff");
    game.nextPosition1 = "fakeBob";
    game.nextPosition2 = "blorbSpies";
    game.con.repaint();
    game.con.revalidate();
    }
    public void fakeBob(){
        game.mainTextArea.setText("\"I knew it!\" the solicitor exclaims, \"Take him down Bubby; we cannot let another Bob "+
            "supporter roam free!\"");
        fight();
        //sf.fight();
        game.con.revalidate();
        game.con.repaint();
    }
    public void blorbSpies(){
        game.mainTextArea.setText("\"Sweet! You are just the person we are looking for.\" the solicitor exclaimes, \"My name's "+
            "Fruitiger, this is my parnter Bubby. We are looking for people to help us stop SuperBob and his minions. We are a " +
            "bit outnumbered by the Bob army, but, with people like you, we can turn the tides. So, what do you say?\"");
        game.choice1.setText("Join the Blorb army");
        game.choice2.setText("No thanks. Just let me scroll");
        game.con.repaint();
        game.con.revalidate();
    }
}