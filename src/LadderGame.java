public class LadderGame {

    private final int numberOfParticipants;
    private final int height;
    private final Ladder ladder;

    LadderGame(int numberOfParticipants, int height) {
        this.numberOfParticipants = numberOfParticipants;
        this.height = height;

        ladder = new Ladder(numberOfParticipants, height);
    }

    public void displayLadder() {
        System.out.println(ladder);
    }

    public void play() {

    }
}
