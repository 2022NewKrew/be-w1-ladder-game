package LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final int ladderWidth, ladderHeight;
    private final Random random = new Random();

    private final List<Line> ladder;

    public Ladder(int ladderWidth, int ladderHeight) {
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
        this.ladder = makeLadder();
    }

    private List<Line> makeLadder() {
        List<Line> ladder = new ArrayList<>();
        for (int row = 0; row < ladderHeight; row++) {
            Line ladderRow = new Line(ladderWidth, random);
            ladder.add(ladderRow);
        }
        return ladder;
    }

    public void printLadder() {
        ladder.forEach((this::printLadderRow));
    }

    private void printLadderRow(Line ladderRow){
        ladderRow.ladderComponents.forEach(System.out::print);
        System.out.println();
    }
}
