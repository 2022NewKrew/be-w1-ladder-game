public class LadderGame {

    private final Ladder ladder;

    public LadderGame(int numberOfPeople, int ladderHeight) throws IllegalArgumentException {
        ladder = new Ladder(numberOfPeople, ladderHeight);
    }

    public void printLadder(){
        System.out.println(ladder);
    }
}
