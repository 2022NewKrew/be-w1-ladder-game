package domain;

import java.util.List;

public class LadderLine {
    private final List<LadderLinePiece> ladderLinePieces;

    public LadderLine(List<LadderLinePiece> ladderLinePieces) {
        this.ladderLinePieces = ladderLinePieces;
    }

    public List<LadderLinePiece> getLadderLinePieces() {
        return ladderLinePieces;
    }
}
