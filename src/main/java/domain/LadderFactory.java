package main.java.domain;

import java.util.List;

public class LadderFactory {
    public static Ladder generateLadder(List<String> peopleNameList, int ladderHeight) {
        Ladder ladder = new Ladder(peopleNameList, ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            ladder.addLadderLine(new Line(peopleNameList.size()));
        }
        return ladder;
    }
}
