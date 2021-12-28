import game.Game;
import game.LadderGame;

public class App {
    public static void main(String[] args) {
        Game game = new LadderGame();
        game.init();
        game.start();
        game.printResult();


    }

}
