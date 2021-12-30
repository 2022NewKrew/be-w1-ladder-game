package domain;

import view.LadderView;

import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private final int personNum, ladderHeight;
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int personNum, int ladderHeight) {
        this.personNum = personNum;
        this.ladderHeight = ladderHeight;
        makeLadder(personNum, ladderHeight);
    }

    public List<Line> getLadder() {
        return ladder;
    }

    private void makeLadder(int personNum, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(personNum));
        }
    }
}
