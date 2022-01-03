import controller.LadderGame;
import utility.RandomGenerator;

public class Application {
    public static void main(String[] args) {
        try {
            RandomGenerator.setSeed(5);
            LadderGame ladderGame = LadderGame.getInstance();
            ladderGame.printLadder();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
