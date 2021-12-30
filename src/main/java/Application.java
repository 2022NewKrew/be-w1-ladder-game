import controller.LadderGame;

public class Application {
    public static void main(String[] args) {
        try {
            LadderGame ladderGame = LadderGame.getInstance();
            ladderGame.printLadder();
            ladderGame.run();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
