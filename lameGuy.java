
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
    game.choiceButtonPanel.remove(game.choice2);
    game.choice1.setText("Continue...");
    if (game.blorbChill == true){
        game.nextPosition1 = "BobNap";
    }else{game.nextPosition1 = "BlorbNap";}
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
        game.drawingPanel.remove(game.artHan);
         game.mainTextArea.setText("\"I knew it!\" the solicitor exclaims, \"Take him down Bubby; we cannot let another Bob "+
            "supporter roam free!\"");
        fight();
        //sf.fight();
        game.choiceButtonPanel.remove(game.choice2);
        game.choice1.setText("Sadly, I haven't got this fight to work; continue");
        game.nextPosition1 = "victory";
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
     public void victory(){
        game.drawingPanel.removeAll();
        game.drawingPanel.add(game.artHan);
        game.mainTextArea.setText("You deliver a crushing blow to the solicitor, who falls to the ground, defeated. "+
            "The solicitor yelps in horror as \"Bubby\" falls to the ground. \"You little twit! You will pay for this!\" he "+
        "says. He grabs his buddy and they both scamper off. What now?");
        game.choiceButtonPanel.add(game.choice2);
        game.choice1.setText("Take a nap");
        game.choice2.setText("Join the Bob army");
        game.nextPosition1 = "nap";
        game.nextPosition2 = "BoblessArmy";
        game.con.repaint();
        game.con.revalidate();
    }
    public void BobNap(){
        game.mainTextArea.setText("You hear glass shattering. Dazed, you sit up in your bed. Something is wrong. "+
        "\"You have nowhere to run, you worthless man!\" a voice shouts.");
        game.choiceButtonPanel.remove(game.choice2);
        game.choiceButtonPanel.add(game.choice2);
        game.choice1.setText("RUN");
        game.choice2.setText("HIDE");
    }
    public void BlorbNap(){
        game.mainTextArea.setText("You wake up to the sound of a loud knock. Dazed, you get out of bed and walk to the door."+
        "You check the peephole to see who it is. It's Blorb! \"Let me in, filth! You will pay! You will pay!\" he shouts." +
    "\"I'm not letting you in Blorb!\" you yell back. \"Perhaps not, and if so, I will let myself in!\" He pulls a "+
"battering ram from behind his back and slams it into your door.");
        game.choiceButtonPanel.remove(game.choice2);
        game.choiceButtonPanel.add(game.choice2);
        game.choice1.setText("RUN");
        game.choice2.setText("HIDE");
        game.nextPosition1 = "BlorbRUN";
        game.nextPosition2 = "BlorbHIDE";
    }
    public void BlorbRUN(){
        game.mainTextArea.setText("You sprint towards the back door as fast as your little legs can carry you. *CRASH!* "+
        "The door splinters to peices behind you. \"Haha! You cannot escape me!\" Blorb yells. You sprint into your room and slam "+
    "the door behind you. \"You think this will stop me?\" Blorb shouts, as he begins to batter down your door. You open your "+
"window and leap out. You run out of the neighborhood and out of the town, never to return.");
        game.choiceButtonPanel.remove(game.choice2);
        game.choice1.setText("Continue...");
    }
    public void BlorbHIDE(){}
    public void lameEnding(){}
}
