public class LadderGame {

    public static void main(String[] args) {

        startGame();

    }

    public static void startGame() {

        Ladder ladder = new Ladder();

        ladder.getInput();
        ladder.makeLadder();
        ladder.printLadder();

    }

}
