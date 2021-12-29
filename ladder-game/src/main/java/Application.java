import controller.LadderGame;
import view.UserInput;

public class Application {
    public static void main(String[] args) {
        try {
            LadderGame ladderGame = LadderGame.getInstance(UserInput.getNumberOfPeople(), UserInput.getLadderHeight());
            ladderGame.printLadder();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
