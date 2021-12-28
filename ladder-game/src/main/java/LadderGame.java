public class LadderGame {

    public static LadderGame INSTANCE;

    private final Ladder ladder;

    private LadderGame(int numberOfPeople, int ladderHeight) throws IllegalArgumentException {
        ladder = new Ladder(numberOfPeople, ladderHeight);
    }

    public static synchronized LadderGame getInstance(int numberOfPeople, int ladderHeight) throws IllegalArgumentException {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame(numberOfPeople, ladderHeight);
        }
        return INSTANCE;
    }

    public void printLadder() {
        System.out.println(ladder);
    }

}
