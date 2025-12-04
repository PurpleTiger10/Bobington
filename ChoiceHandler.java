import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoiceHandler implements ActionListener{
  Bobington game;
  badGuy bad;
  bobGuy bob;
  boblessGuy bobless;
  lameGuy lame;
  goodGuy good;
  pachanakanwa pach;
  public ChoiceHandler(Bobington game, badGuy bad, bobGuy bob, boblessGuy bobless, lameGuy lame, goodGuy good, pachanakanwa pach){
      this.game = game;
      this.bad = bad;
      this.bob = bob;
      this.bobless = bobless;
      this.lame = lame;
      this.good = good;
      this.pach = pach;
  }
  public void selectPosition(String nextPosition){
    switch(nextPosition){
    case "start": game.start(); break;
    case "start1": game.start1(); break;
    case "start2": game.start2(); break;
    case "startHouse": game.startHouse(); break;
    case "grocery": game.grocery(); break;
    case "walk": game.walk(); break;
    case "recruitment": game.recruitment(); break;
    case "horrors": game.horrors(); break;
    case "police": game.police(); break;
    case "BlorbBase": game.bad.BlorbBase(); break;
    case "BobArmy": bob.BobArmy(); break;
    case "findBlorbOptions": game.bob.findBlorbOptions(); break;
    case "pach": game.bob.pach(); break;
    case "followBlorb": game.bob.followBlorb(); break;
    case "bobUnder": game.bob.bobUnder(); break;
    case "bobFactory": game.bob.bobFactory(); break;
    case "spywork": good.spywork(); break;
    case "BoblessArmy": game.bobless.BoblessArmy(); break;
    case "boblessUnder": game.bobless.boblessUnder(); break;
    case "boblessFactory": game.bobless.boblessFactory(); break;
    case "home": game.lame.home(); break;
    case "scroll": game.lame.scroll(); break;
    case "nap": game.lame.nap(); break;
    case "fakeBob": game.lame.fakeBob(); break;
    case "blorbSpies": game.lame.blorbSpies(); break;
    case "attempts": game.pach.attempts(); break;
    case "walk2": game.walk2(); break;
    case "walkCan": game.walkCan(); break;
    case "walkWho": game.walkWho(); break;
    case "walkBob": game.walkBob(); break;
    case "walkSick": game.walkSick(); break;
    case "walkBob2": game.walkBob2(); break;
    case "walkSick2": game.walkSick2(); break;
    case "walkSick3": game.walkSick3(); break;
    case "walkSorry": game.walkSorry(); break;
    case "walkKnow": game.walkKnow(); break;
    case "walkKnow2": game.walkKnow2(); break;
    case "walkNo": game.walkNo(); break;
    case "walkWell": game.walkWell(); break;
    case "walkToRec": game.walkToRec(); break;
    case "recWho": game.recWho(); break;
    case "recWhat": game.recWhat(); break;
    case "recNah": game.recNah(); break;
    case "horrors2": game.horrors2(); break;
    case "horrors3": game.horrors3(); break;
    case "horrors4": game.horrors4(); break;
    case "police2": game.police2(); break;
    case "police3": game.police3(); break;
    case "police4": game.police4(); break;
    case "police5": game.police5(); break;
    case "BoblessArmy2": bobless.BoblessArmy2(); break;
    case "BoblessArmy3": bobless.BoblessArmy3(); break;
    case "scroll2": lame.scroll2(); break;
    }
  }

public void actionPerformed(ActionEvent event){
   String yourChoice = event.getActionCommand();
   switch(game.position){
       case "start":
           switch(yourChoice){
               case "c1": selectPosition(game.nextPosition1); break;
               case "c2": selectPosition(game.nextPosition2); break;
               case "c3": selectPosition(game.nextPosition3); break;
               case "c4": selectPosition(game.nextPosition4); break;
           }
           break;
          case "grocery":
            switch(yourChoice){
              case "c1": 
              selectPosition(game.nextPosition1); 
              game.playerWeapon = "Oodle-Oodle bar"; 
              game.weaponLabelName.setText("" + game.playerWeapon);
              game.position = "start"; 
              break;
              case "c2": 
              selectPosition(game.nextPosition2); 
              game.playerWeapon = "Slackers"; 
              game.weaponLabelName.setText("" + game.playerWeapon);
              game.position = "start"; 
              break;
            }
        }
    }
}
