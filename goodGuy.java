public class goodGuy{
    private Bobington game;
    public goodGuy(Bobington game) {
        this.game = game;
    }
    public void spywork(){
    game.position = "spywork";
    game.mainTextArea.setText("spywork stuffies.");
    }
}