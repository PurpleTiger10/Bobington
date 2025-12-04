public class badGuy{
    private Bobington game;
    public badGuy(Bobington game) {
        this.game = game;
    }
    public void BlorbBase(){
    game.position = "BlorbBase";
    game.mainTextArea.setText("Your in da base! I actually don't know what happens from here on out. :(");
    
    game.nextPosition1 = "";
    game.nextPosition2 = "";
    }
}