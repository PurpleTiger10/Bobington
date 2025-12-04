import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import FIGHT.GamePanel;
import FIGHT.keyHandler;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Bobington {
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 double width = screenSize.getWidth();
 double height = screenSize.getHeight();
 double resize = (width < 2000 || height < 1300) ? 2 : 1;
 JFrame window;
 Container con;
 JTextField nameInput;
 JPanel titleNamePanel, startBottomPannel, mainTextPanel, choiceButtonPanel, playerPanel, drawingPanel;
 JLabel titleNameLabel, HPLabel, HPLabelNumber, weaponLabel, weaponLabelName;
 Font titleFont = new Font("Times New Roman", Font.PLAIN, (int)(190/resize));
 Font startFont = new Font("Times New Roman", Font.PLAIN, (int)(90/resize));
 Font normalFont = new Font("Times New Roman", Font.PLAIN, (int)(45/resize));
 JButton startButton, choice1, choice2, choice3, choice4;
 String backgroundColor = "#221729", playerName;
 JTextArea mainTextArea;
 int playerHP;
 keyHandler keyH = new keyHandler();
 String playerWeapon, position;
 GamePanel panel = new GamePanel();
 badGuy bad = new badGuy(this);
 bobGuy bob = new bobGuy(this);
 boblessGuy bobless = new boblessGuy(this);
 lameGuy lame = new lameGuy(this,keyH,panel);
 goodGuy good = new goodGuy(this);
 pachanakanwa pach = new pachanakanwa(this);
 String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
 ChoiceHandler choiceHandler = new ChoiceHandler(this, bad, bob, bobless, lame, good, pach);
 Boolean blorbChill = false, blorbEncounter = false;
 public static void main(String[] args) {
     new Bobington();
 }

 public Bobington(){
     System.out.println(screenSize);
     TitleScreenHandler tsHandler = new TitleScreenHandler();
     window = new JFrame();
     window.setSize((int)(1600/resize),(int)(1200/resize));
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setResizable(false);
     window.getContentPane().setBackground(Color.decode("#221729"));
     window.setTitle("Bobington");
     window.setLayout(null);
     window.setVisible(true);
     con = window.getContentPane();

     titleNamePanel = new JPanel();
     titleNamePanel.setBounds((int)(200/resize),(int)(200/resize),(int)(1200/resize),(int)(300/resize));
     titleNamePanel.setBackground(Color.decode("#221729"));
     titleNameLabel = new JLabel("BOBINGTON");
     titleNameLabel.setForeground(Color.decode("#ffffff"));
     titleNameLabel.setFont(titleFont);

     startBottomPannel = new JPanel();
     startBottomPannel.setBounds((int)(600/resize),(int)(800/resize),(int)(400/resize),(int)(200/resize));
     startBottomPannel.setBackground(Color.decode(backgroundColor));

     startButton = new JButton("Start.");
     startButton.setBackground(Color.decode(backgroundColor));
     startButton.setForeground(Color.WHITE);
     startButton.setFont(startFont);
     startButton.setFocusPainted(false);       // removes focus outline
     startButton.setBorderPainted(true);      // removes extra inner border
     startButton.setContentAreaFilled(true);
     startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));   // keeps the filled background
     startButton.addActionListener(tsHandler);

     startBottomPannel.add(startButton);

     titleNamePanel.add(titleNameLabel);
     con.add(titleNamePanel);
     con.add(startBottomPannel);
 }
 public void createGameScreen() {
     titleNamePanel.setVisible(false);
     startBottomPannel.setVisible(false);

     drawingPanel = new JPanel();
     drawingPanel.setBounds((int)(100/resize),(int)(30/resize),(int)(600/resize),(int)(900/resize));
     drawingPanel.setBackground(Color.decode("#00cccc"));

     mainTextPanel = new JPanel();
     mainTextPanel.setBounds((int)(800/resize),(int)(30/resize),(int)(700/resize),(int)(550/resize));
     mainTextPanel.setBackground(Color.decode(backgroundColor));

     mainTextArea = new JTextArea("This is the main text eyah! (I meant to write \"yeah,\" but it came out as \"eyah!\")");
     mainTextArea.setBounds((int)(800/resize),(int)(30/resize),(int)(700/resize),(int)(550/resize));
     mainTextArea.setBackground(Color.decode(backgroundColor));
     mainTextArea.setForeground(Color.WHITE);
     mainTextArea.setFont(normalFont);
     mainTextArea.setLineWrap(true);

     choiceButtonPanel = new JPanel();
     choiceButtonPanel.setBounds((int)(100/resize),(int)(1000/resize),(int)(1400/resize),(int)(100/resize));
     choiceButtonPanel.setBackground(Color.decode(backgroundColor));
     choiceButtonPanel.setLayout(new GridLayout(1,4));

     choice1 = new JButton("Choice 1");
     choice1.setBackground(Color.decode(backgroundColor));
     choice1.setForeground(Color.WHITE);
     choice1.setFont(normalFont);
     choice1.setFocusPainted(false);
     choice1.addActionListener(choiceHandler);
     choice1.setActionCommand("c1");

     choice2 = new JButton("Choice 2");
     choice2.setBackground(Color.decode(backgroundColor));
     choice2.setForeground(Color.WHITE);
     choice2.setFont(normalFont);
     choice2.setFocusPainted(false);
     choice2.addActionListener(choiceHandler);
     choice2.setActionCommand("c2");

     choice3 = new JButton("Choice 3");
     choice3.setBackground(Color.decode(backgroundColor));
     choice3.setForeground(Color.WHITE);
     choice3.setFont(normalFont);
     choice3.setFocusPainted(false);
     choice3.addActionListener(choiceHandler);
     choice3.setActionCommand("c3");

     choice4 = new JButton("Choice 4");
     choice4.setBackground(Color.decode(backgroundColor));
     choice4.setForeground(Color.WHITE);
     choice4.setFont(normalFont);
     choice4.setFocusPainted(false);
     choice4.addActionListener(choiceHandler);
     choice4.setActionCommand("c4");

     playerPanel = new JPanel();
     playerPanel.setBounds((int)(800/resize),(int)(600/resize),(int)(600/resize),(int)(300/resize));
     playerPanel.setBackground(Color.decode(backgroundColor));
     playerPanel.setLayout(new GridLayout(4,2));

     HPLabel = new JLabel("HP: ");
     HPLabel.setFont(normalFont);
     HPLabel.setForeground(Color.white);

     HPLabelNumber = new JLabel("");
     HPLabelNumber.setFont(normalFont);
     HPLabelNumber.setForeground(Color.white);

     weaponLabel = new JLabel("Item: ");
     weaponLabel.setFont(normalFont);
     weaponLabel.setForeground(Color.white);

     weaponLabelName = new JLabel("");
     weaponLabelName.setFont(normalFont);
     weaponLabelName.setForeground(Color.white);

     playerPanel.add(HPLabel);
     playerPanel.add(HPLabelNumber);
     playerPanel.add(weaponLabel);
     playerPanel.add(weaponLabelName);
     mainTextPanel.add(mainTextArea);
     choiceButtonPanel.add(choice1);
     choiceButtonPanel.add(choice2);
     choiceButtonPanel.add(choice3);
     choiceButtonPanel.add(choice4);
     con.add(drawingPanel);
     con.add(mainTextPanel);
     con.add(choiceButtonPanel);
     con.add(playerPanel);

     playerSetup();

     con.revalidate();
     con.repaint();
 }
 public class TitleScreenHandler implements ActionListener{
     public void actionPerformed(ActionEvent event){
         createGameScreen();
     }
 }
 public void playerSetup(){
     playerHP = 15;
     playerWeapon = "";
     weaponLabelName.setText(playerWeapon);
     HPLabelNumber.setText(""+playerHP);

    //start();
    bobless.BoblessArmy();
     con.revalidate();
     con.repaint();
 }
 public void start(){
     position = "start";
     choice1.setText("Enter your name to continue");
     choiceButtonPanel.remove(choice2);
     choiceButtonPanel.remove(choice3);
     choiceButtonPanel.remove(choice4);
     mainTextArea.setText("Hello there! What's your name?");
     mainTextPanel.setBounds((int)(800/resize),(int)(30/resize),(int)(700/resize),(int)(136/resize));
     nameInput = new JTextField(20);
     nameInput.setBounds((int)(800/resize),(int)(60/resize),(int)(700/resize),(int)(60/resize));
     nameInput.setFont(normalFont);
     nameInput.setBackground(Color.decode(backgroundColor));
     nameInput.setForeground(Color.WHITE);
     nameInput.setCaretColor(Color.WHITE);
         nameInput.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
         String userInput = nameInput.getText().trim();
         handleUserInput(userInput);
         nameInput.setText(""); // clear after pressing enter
     }
 });
  mainTextPanel.add(nameInput);
 }
     public void handleUserInput(String name) {
 if (name.isEmpty()) return; // ignore blank input

 mainTextPanel.setBounds((int)(800/resize),(int)(30/resize),(int)(700/resize),(int)(550/resize));
 mainTextArea.setBounds((int)(800/resize),(int)(30/resize),(int)(700/resize),(int)(550/resize));
 mainTextPanel.remove(nameInput);
 playerName = name;
 mainTextArea.setText("Nice to meet you, " + playerName + ".");

 choice1.setText("Continue");
 nextPosition1 = "start1";

 con.revalidate();
 con.repaint();
}

 public void start1(){
     mainTextArea.setText("You are about to " +
 "embark on a journey \nof a lifetime, and it all starts in a happy" +
 "town by the name of Bobington. You, \nof course, do not know you are" +
 " about \nto start an adventure, because if you \ndid, you would have " +
 "never moved in \nthe first place, as you are a lazy twit \nwho " +
 "only cares about comfort and \nnever touches grass.");

     nextPosition1 = "start2";
     con.revalidate();
     con.repaint();
 }

 public void start2(){
     mainTextArea.setText("     Well anyways... You have moved \ninto a lovely single " +
 "story house. It isn't massive, but it fits all your needs. \n     You " +
 "set up the important things, \nlike the furniture, the bedroom, " +
 "and, \nmost importantly, your TV, so that youcan ScreenCast " +
 "your scrolling to the \nbig screen.");

 nextPosition1 = "startHouse";

 con.revalidate();
 con.repaint();
 }

 public void startHouse(){
     choiceButtonPanel.add(choice2);
     choiceButtonPanel.remove(choice3);
     choiceButtonPanel.remove(choice4);
     mainTextArea.setText("     There\'s a grocery store nearby, so \nyou can go " +
 "grab some snacks and stuff, or you can walk around the " +
 "\nneighborhood to get a bit of \nunderstanding about where you live.");
 choice1.setText("Go to the grocery store.");
 choice2.setText("Go for a walk.");

 nextPosition1 = "grocery";
 nextPosition2 = "walk";
 con.revalidate();
 con.repaint();
 }




 public void grocery(){
    position = "grocery";
     mainTextArea.setText("You enter the grocery store to find \nsome snacks. You pace up and down \nthe aisles, trying to decide which snack you want.");

     choice1.setText("Oodle-Oodle Bar");
     choice2.setText("Slackers");

     nextPosition1 = "recruitment";
     nextPosition2 = "recruitment";
     con.revalidate();
     con.repaint();
 }




 public void walk(){
    blorbEncounter = true;
     choiceButtonPanel.remove(choice2);
     mainTextArea.setText("You walk out the door and begin to \nexplore the niegborhood. You smell thescent of freshly cut grass as the sun \nbeams down on your skin. \n\nWhat a wonderful day!");

     choice1.setText("Continue");

     nextPosition1 = "walk2";
     con.revalidate();
     con.repaint();
 }

public void walk2(){
   choiceButtonPanel.add(choice2);
   mainTextArea.setText("Suddenly, a white van skids to a stop \nnext to you. The window rolls down, \nand the driver... who is a cat... stares \ndirectly at you. \"Greetings, human.\" he says.");

   choice1.setText("Can I help you?");
   choice2.setText("Who the absolute heck are you?!");

   nextPosition1 = "walkCan";
   nextPosition2 = "walkWho";
}

public void walkCan(){
   mainTextArea.setText("\"Why, of course I can use your help.\" He says, \"My name is Blorb, or Big \nBoss Blorb, " +
   "if you prefer. I see that youare new here, so I knew I had to get to you before those horrid \'Bob army\' " +
   "\nfellows got to you. And that is exactly why I need your help. The Bob army is taking over the entirety of " +
   "Bobington, and I need your help to turn the tides, and stop them once and for all.\"");

   choice1.setText("Who is the Bob army?");
   choice2.setText("Well, what do you need me to do?");

   nextPosition1 = "walkBob";
   nextPosition2 = "walkWell";
}

public void walkWell(){
   mainTextArea.setText("I need you to help me stop SuperBob, and on top of that, cleanse the city from its filth and germs! Will you join me?");

   choice1.setText("Sure");
   choice2.setText("No thanks");

   nextPosition1 = "BlorbBase";
   nextPosition2 = "walkNo";
}

public void walkWho(){
   mainTextArea.setText("\"Me? I am Big Boss Blorb, or just \nBlorb if you prefer. I am the leader of \nthe " +
   "anti-Bob and anti-sick \norganization.\"");

   choice1.setText("Anti-Bob?");
   choice2.setText("Anti-sick?");

   nextPosition1 = "walkBob";
   nextPosition2 = "walkSick";
}

public void walkBob(){
   choiceButtonPanel.remove(choice2);
   mainTextArea.setText("\"Oh those horrid people. You see, I \nreally don\'t mind the people of \nBobington much " +
   "(other than the sick \nones, of course), but recently, they \nhave mostly turned against me! And it " +
   "was all because of Super-Bob, the \nleader of them all. Pathetic!");

   choice1.setText("Continue");

   nextPosition1 = "walkBob2";
}

public void walkBob2(){
   choiceButtonPanel.add(choice2);
   mainTextArea.setText("All I have been trying to do is rid \nBobington of those who must be rid of, and cleanse " +
   "the city, but what do they \ncare about that? They just want to \ncontinue living on in their filth and \nsicknesses " +
   "I suppose. But please, I \ndon\'t have many on my side, so would you join me in my attempts to cleanse Bobington of germs?\"");

   choice1.setText("Sure");
   choice2.setText("No thanks");

   nextPosition1 = "BlorbBase";
   nextPosition2 = "walkNo";
}

public void walkSick(){
   choiceButtonPanel.remove(choice2);
   mainTextArea.setText("I know, it may sound strange to you, \nbut I am truly justified in my hating of " +
   "\nthe sick. You see, when I was a little \nboy, I always wanted to go to Udjat\'s \nDoughnuts. I yearned to "+
   "try the rides, \nand eat the world renowned doughnuts Ihad always dreamed of eating. \nOne day, my dreams came to fruition " +
   "\nwhen my friends invited me to go with \nthem the next day.");

   choice1.setText("Continue");

   nextPosition1 = "walkSick2";
}


public void walkSick2(){
   mainTextArea.setText("\"Of course I accepted. I could not haveever been more happy than I was at thatmoment. " +
   "I rushed home that day, and \nwent to bed as fast as I could. I \ncouldn\'t wait until tomorrow. And \nfinally, tomorrow " +
   "came. \nBut what\'s this? I was horribly \nlightheaded, and I felt sick to my \nstomach.\"");

   nextPosition1 = "walkSick3";
}

public void walkSick3(){
   choiceButtonPanel.add(choice2);
   mainTextArea.setText(" I told my mom I wasn\'t feeling well, \nand she… *sniff* she told me I had a \nfever, and I " +
   "couldn\'t go to Udjat\'s with my friends. The sick people, you see, \ncompletely ruined my childhood " +
   "by \ninfecting me with their atrocities, and \nthus, I must pay them back. For\njustice, for Udjat\'s, and for " +
   "little Blorb, who just wanted to play with his \nfriends.\"");

   choice1.setText("I\'m sorry to hear that");
   choice2.setText("That wasn't their fault");

   nextPosition1 = "walkSorry";
   nextPosition2 = "walkKnow";
}

public void walkSorry(){
   blorbChill = true;
   mainTextArea.setText("Thank you very much. Most… most people don't care for me. I am constantly left out by others and " +
   "looked down upon, so… you really don't know how much it means to me to hear you say that.  Now, please, you can just " +
   "go on, but would you join me in my attempts to cleanse Bobington of germs?");




   choice1.setText("Sure");
   choice2.setText("No thanks");




   nextPosition1 = "BlorbBase";
   nextPosition2 = "walkNo";
}

public void walkKnow(){
    choiceButtonPanel.remove(choice2);
   mainTextArea.setText("\"OF COURSE IT IS! By jove, if it wasn't for them, I would have gotten to go to Udjat's Doughnuts! " +
   "Why, you are no worse than the others of this city. Go on! Join the Bob army, I don't care. You are a lost cause, " +
   "and I will have no pity for you if you become sick, because you had no pity for me.\" He drives off.");

   choice1.setText("Continue");

   nextPosition1 = "walkKnow2";
}


public void walkKnow2(){
    mainTextArea.setText("Blorb will remember that.");


    nextPosition1 = "walkToRec";
}


public void walkNo(){
    choiceButtonPanel.remove(choice2);
    mainTextArea.setText("\"You fool.\" He says. He reaches into the glove box, pulls out a bottle of hand-sanitizer, and squirts it into your eyes. With this, he drives away.\n\nBlorb will remember that.");
    playerHP--;
    HPLabelNumber.setText("" + playerHP);


    choice1.setText("Continue");


    nextPosition1 = "walkToRec";
}







public void walkToRec(){
    choiceButtonPanel.add(choice2);
    mainTextArea.setText("\"Well that was weird\" You think. Well anyways, you continue your walk. Eventually, you get to the grocery store.");


    choice1.setText("Go inside");
    choice2.setText("Go home");


    nextPosition1 = "grocery";
    nextPosition2 = "recruitment";
}

 public void recruitment(){
  choiceButtonPanel.add(choice2);
  mainTextArea.setText("You begin to head home, when a random solicitor stops you. \"Hello, sorry to stop you sir,\" she says, \"But would you like to join the Bob army? We are here to protect the sick and all else who are in danger.");
  if (blorbEncounter==false){
    choice1.setText("Protect? From who?");
    nextPosition1 = "recWho";
  }else{
    choice1.setText("What does Blorb do?");
    nextPosition1 = "recWhat";}
  choice2.setText("Nah, no thanks.");




  nextPosition2 = "recNah";
 }


public void recWho(){
    mainTextArea.setText("Protect them from Blorb, of course! Everytime word goes around that someone is sick, Blorb finds them and… well… he sprays hand sanitizer in their eyes, assuming it will make them less sick. Please, sir, we need your help, and we must catch this menace of a cat");


    choice1.setText("Sure");
    choice2.setText("Nah, no thanks");


    nextPosition1 = "BobArmy";
    nextPosition2 = "recNah";
}


public void recWhat(){
    mainTextArea.setText("Everytime word goes around that someone is sick, Blorb finds them and… well… he sprays hand sanitizer in their eyes, assuming it will make them less sick. I don't know why he does it in such a cruel way, but he must be stopped! Please, sir, we need your help, and we must catch this menace of a cat.");


    choice1.setText("Sure");
    choice2.setText("Nah, no thanks");


    nextPosition1 = "BobArmy";
    nextPosition2 = "recNah";
}


public void recNah(){
    choiceButtonPanel.remove(choice2);
    mainTextArea.setText("\"Oh please sir! Think about the sick! We can't let this happen to them!\" \n\"I said, I'm good.\" You say, and walk off.");


    choice1.setText("Continue");


    nextPosition1 = "horrors";
}








 public void horrors(){
  mainTextArea.setText("You grab your " + playerWeapon + " and begin to head home. Suddenly, A white van " +
  "slides to a stop right next to the recruitment center. None other than Blorb himself has come onto the " +
  "scene. He and a few of his goons immediately begin to douse hand-sanitizer onto the recruiters. Screams " +
  "of horror and desperation erupt from the scene. You watch, petrified.");
 
  nextPosition1 = "horrors2";
 }

 public void horrors2(){
    mainTextArea.setText("But what's that?! Is it a bird? Is it a plane? No, it's SuperBob!!! " +
    "SuperBob sails right into the battlefield to save the day!");

    nextPosition1 = "horrors3";
 }

public void horrors3(){
    mainTextArea.setText("*squirt*");

    nextPosition1 = "horrors4";
}

public void horrors4(){
    mainTextArea.setText("SuperBob screeches in pain, and convulses on the ground, trying to get the hand-sanitizer " +
    "out of his eyes. Blorb and his henchmen hop in the van and drive away at breakneck speed.");

    choiceButtonPanel.add(choice2);
    choiceButtonPanel.add(choice3);
    choice1.setText("Join the Bob Army");
    choice2.setText("Join Blorb");
    choice3.setText("Call the police");

    nextPosition1 = "BoblessArmy";
    nextPosition2 = "BlorbBase";
    nextPosition3 = "police";
}






 public void police(){
    position = "start";
  mainTextArea.setText("Welcome to Bobbington! We are very sorry, but our landline is broken at the moment. " +
  "If you have an emergency, please hurry over to the Police Station in the roundabout at Dixfield road and Millbob " +
  "street. Thank you! Shoot, you say. You put your phone in your pocket and dash off in that direction. You bust " +
  "through the front doors of the station.");
  choiceButtonPanel.remove(choice2);
  choiceButtonPanel.remove(choice3);

  choice1.setText("Continue");

  nextPosition1 = "police2";
 }

public void police2(){
    mainTextArea.setText("Quick! It's the cat! Blorb! He's just attacked a group of people at Philippe's Grocery Store! He got " +
    "some sort of flying man as well. Everyone's in pain, please hurry! A large group of the policemen spring from their " +
    "chairs and skedaddle out the door. Thank you for your haste, and sorry that the line was out. The dispatcher says. " +
    "No worries. You say.");

    nextPosition1 = "police3";
}

public void police3(){
    mainTextArea.setText( "What's your name? " + playerName + ", you say. " + playerName + 
    "… I don't think you're on our lists anywhere. You must be new here!");

    nextPosition1 = "police4";
}

public void police4(){
    mainTextArea.setText("So, I think it should be apparent that something is amiss in this town. A cat by the name of Blorb " +
    "has been attacking the sick with bottles of hand-sanitizer. Lately, he's been starting to attack more than just the " +
    "sick, but also those who stand up against him. So, it's clear that he must be stopped.");

    nextPosition1 = "police5";
}

public void police5(){
    mainTextArea.setText("So, I have a proposition for you. Would you like to join the Bob army, or would you like to sign " +
    "up to be a spy. You can also go home of course, your choice.");

    choiceButtonPanel.add(choice2);
    choiceButtonPanel.add(choice3);

    choice1.setText("Join the Bob Army");
    choice2.setText("Sign up to spy");
    choice3.setText("Go home");

    nextPosition1 = "BoblessArmy";
    nextPosition2 = "spywork";
    nextPosition3 = "home";
}








 /*
 public static void wait(int x) {
 try {
     Thread.sleep(x);
   } catch (InterruptedException e) {
     e.printStackTrace();
   }
}*/
/*
public void typewriterEffect(String text, int delay) {
 mainTextArea.setText("");
 char[] chars = text.toCharArray();
 final int[] index = {0};
 final StringBuilder builder = new StringBuilder();
 javax.swing.Timer timer = new javax.swing.Timer(delay, new ActionListener() {
     public void actionPerformed(ActionEvent e) {
         builder.append(chars[index[0]++]);
         mainTextArea.setText(builder.toString());
         if (index[0] >= chars.length) {
             ((javax.swing.Timer)e.getSource()).stop();
         }
     }
 });
 timer.setCoalesce(true); // merges pending events -> smoother
 timer.start();
}
 */
}



