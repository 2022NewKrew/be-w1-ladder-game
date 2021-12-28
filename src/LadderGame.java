public class LadderGame {

    private final Ladder ladder;
    private final DisplayLadder renderer;

    LadderGame(int numberOfParticipants, int height) {
        ladder = new Ladder(numberOfParticipants, height);
        renderer = new StandardOutDisplayLadder();
    }

    public void displayLadder() {
        renderer.display(ladder);
    }
}
