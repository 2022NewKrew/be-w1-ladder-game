public class LadderService {
    private Ladder ladder;

    public void makeLadder(int height, int manCount) {
        ladder = Ladder.getInstance(height, manCount);
    }

    public Ladder getLadder() {
        return ladder;
    }

}
