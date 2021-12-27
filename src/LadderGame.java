public class LadderGame {

    private final Ladder ladder;

    public LadderGame(int numOfPlayer, int ladderHeight) {
        this.ladder = new Ladder(numOfPlayer, ladderHeight);
    }

    public void start() {
        ladder.connect();
        ladder.print();
    }
}
