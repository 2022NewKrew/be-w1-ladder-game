package domain;

import java.util.ArrayList;
import java.util.List;

public class CreateLadder {
    private final List<LadderLine> ladder = new ArrayList<>();

    public CreateLadder(Integer playersNum, Integer maximumLadderHeight) {
//        this.ladder = createLine();
        ladder.add(createLadderLine());
    }

    private LadderLine createLadderLine() {
        return new LadderLine();
    }

    private LadderLinePiece createLadderLinePiece() {
        return new LadderLinePiece();
    }
}
