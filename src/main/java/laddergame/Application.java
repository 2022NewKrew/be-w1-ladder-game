package laddergame;

public class Application {

    public static void main(String[] args) {
        final int numberOfGamer = LadderGame.inputNumberOfGamer();
        final int ladderHeight = LadderGame.inputLadderHeight();
        LadderGame ladderGame = LadderGame.of(numberOfGamer, ladderHeight);
        ladderGame.printLadder();
    }
}
