package LadderGame.domain.Ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int ladderWidth, ladderHeight;
    private final List<Line> ladder;

    public Ladder(int ladderWidth, int ladderHeight) {
        validateLadderHeight(ladderHeight);
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
        this.ladder = makeLadder();
    }

    private void validateLadderHeight(int ladderHeight){
        if(ladderHeight < 1){
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    private List<Line> makeLadder() {
        List<Line> ladder = new ArrayList<>();
        for (int row = 0; row < ladderHeight; row++) {
            Line ladderRow = new Line(ladderWidth);
            ladder.add(ladderRow);
        }
        return ladder;
    }

    public void printLadder() {
        ladder.forEach((this::printLadderRow));
    }

    private void printLadderRow(Line ladderRow){
        System.out.println(ladderRow.toString());
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
