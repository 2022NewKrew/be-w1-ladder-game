public class Application {
    static public void main(String[] args) {
        try {
            LadderGame ladderGame = new LadderGame(UserInput.getNumberOfPeople(), UserInput.getLadderHeight());
            ladderGame.printLadder();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
