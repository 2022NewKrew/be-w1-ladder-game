package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    public Ladder createLadder(Integer playersNum, Integer maximumLadderHeight) {
        List<LadderLine> ladder = new ArrayList<LadderLine>();
        for (int i = 0; i < maximumLadderHeight; i++) {
            ladder.add(new LadderLine(createLadderLine(playersNum)));
        }
        return new Ladder(ladder);
    }

    private List<LadderLinePiece> createLadderLine(Integer playersNum) {
        List<LadderLinePiece> pieces = new ArrayList<>();
        for (int i = 0; i < playersNum * 2 - 1; i++) {
            pieces.add(createLadderLinePiece(i));
        }
        return pieces;
    }

    private LadderLinePiece createLadderLinePiece(int i) {
        if (i % 2 == 0) {
            return LadderLinePiece.VERTICAL;
        }
        return (Math.random() > 0.6) ? LadderLinePiece.EMPTY : LadderLinePiece.HORIZONTAL;
    }
}
