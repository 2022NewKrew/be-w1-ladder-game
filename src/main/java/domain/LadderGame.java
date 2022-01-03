package domain;


import java.util.List;


public class LadderGame {
    private final Ladder ladder;
    private final List<Item> ladderInputs;

    public LadderGame(int ladderWidth, int ladderHeight, List<Item> ladderInputs) {
        ladder = new Ladder(ladderWidth, ladderHeight);
        this.ladderInputs = ladderInputs;
    }

    public Ladder getLadder() {
        return ladder;
    }

    @Override
    public String toString() {
        return "LadderGame{" +
                "ladder=" + ladder +
                ", ladderInputs=" + ladderInputs +
                '}';
    }

    public List<Item> getLadderInputs() {
        return ladderInputs;
    }
}
