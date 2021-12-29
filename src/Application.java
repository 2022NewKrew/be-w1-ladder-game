import ladder.LadderGame;
import view.ApplicationInput;

public class Application {
    public static void main(String[] args) {
        ApplicationInput input = new ApplicationInput();
        LadderGame ladderGame = new LadderGame(input.getPlayers(), input.getHeight());
        System.out.println(ladderGame.printLadder());
    }
}
