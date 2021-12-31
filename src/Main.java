import domain.LadderGame;
import view.StandardInputLadderGameInputManager;
import view.StandardOutLadderGameRenderer;

public class Main {
    public static void main(String[] args) {
        LadderGame game = new LadderGame(new StandardInputLadderGameInputManager(), new StandardOutLadderGameRenderer());
        game.play();
    }
}
