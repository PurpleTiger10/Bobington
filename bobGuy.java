public class bobGuy{
   private Bobington game;
   public bobGuy(Bobington game) {
       this.game = game;
   }
   public void BobArmy(){
   game.position = "BobArmy";
   game.mainTextArea.setText("Your in da army! I actually don't know what happens from here on out. :( Oh wait, either find Blorb or contact the Kamchatka or something like that.");
   game.choice1.setText("Find Blorb");
   game.choice2.setText("Pachanakanwa");

   game.nextPosition1 = "findBlorbOptions";
   game.nextPosition2 = "pach";
   }
   public void findBlorbOptions(){
       game.position = "findBlorbOptions";
       game.mainTextArea.setText("Oh yaeh");
       game.choice1.setText("Follow Blorb");
       game.choice2.setText("Underground");
       game.choice3.setText("Factory");

       game.nextPosition1 = "followBlorb";
       game.nextPosition2 = "bobUnder";
       game.nextPosition3 = "bobFactory";
   }
   public void pach(){
    game.position = "pach";
    game.mainTextArea.setText("WAIT, this is just in!");
    game.choice1.setText("Pachanakanwa");
    game.choice2.setText("Follow Blorb");

    game.nextPosition1 = "followBlorb";
    game.nextPosition2 = "attempts";
   }
   public void followBlorb(){
       game.position = "followBlorb";
       game.mainTextArea.setText("OH YEAH!");
       game.choice1.setText("Hmm...");
       game.choice2.setText("Ah");
   }
   public void bobUnder(){
       game.position = "bobUnder";
       game.mainTextArea.setText("OH YEAH!");
       game.choice1.setText("Hmm...");
       game.choice2.setText("Ah");
   }
   public void bobFactory(){
       game.position = "bobFactory";
       game.mainTextArea.setText("OH YEAH!");
       game.choice1.setText("Hmm...");
       game.choice2.setText("Ah");
   }
}







