public class boblessGuy{
    private Bobington game;
    public boblessGuy(Bobington game) {
        this.game = game;
    }
    public void BoblessArmy(){
        game.position = "start";
    game.mainTextArea.setText("You timidly walk over to the group of attacked people. Hey, I can help you all, I made a " +
    "mistake when I didn't join the army, but, after what I have seen, I feel as if there is no choice but to fight back. " +
    "May I join the Bob army? Of course you can join. We need as many people as we can get. Here, let's take SuperBob to " +
    "the base, and try to figure out what to do next.");
    game.choiceButtonPanel.remove(game.choice3);
    game.choiceButtonPanel.remove(game.choice2);

    game.choice1.setText("Continue");

    game.nextPosition1 = "BoblessArmy2";
    }

    public void BoblessArmy2(){
        game.mainTextArea.setText("Someone runs out with a stretcher, and you help place SuperBob on it. You and the rest of " +
        "the army run into the grocery store, and into the employee only area. Running to the back, you set him in a hospital " +
        "bed, along with the sick who have been stored there in safety. Okay, SuperBob is out of commission, so to speak, but, " +
        "despite that, we need to get our revenge.");

        game.nextPosition1 = "BoblessArmy3";
    }

    public void BoblessArmy3(){
        game.mainTextArea.setText("I remember SuperBob telling me that there were two possible entrances to Blorb's base, " +
        "however, he never found out which one it was in time. The two possibilities were A: A manhole in Maxwell road, and " +
        "B: a run down factory, possible a hand-sanitizer factory. We should split up, and have one team go to location A, " +
        "and the other location B.");

        game.choiceButtonPanel.add(game.choice2);

        game.choice1.setText("Underground");
        game.choice2.setText("Factory");

        game.nextPosition1 = "boblessUnder";
        game.nextPosition2 = "boblessFactory";
    }

    public void boblessUnder(){
        game.mainTextArea.setText("You and your team run out the door and head to Maxwell. You arrive at the site, and climb " +
        "into the manhole. Inside, there is a candle on a table, and a path, leading off into the darkness.");
        game.choice1.setText("Take the candle");
        game.choice2.setText("Go into the dark");
    }
    public void boblessFactory(){
        game.mainTextArea.setText("You and your team run out the door and head to the factory. You arrive at the site, and " +
        "climb into the abandoned building. As soon as your feet hit the ground, myriads of Blorb's henchmen hop out of the " +
        "shadows. Attack! One of the army men yell.");
        game.choice1.setText("Run");
        game.choice2.setText("FIGHT!");
    }
}