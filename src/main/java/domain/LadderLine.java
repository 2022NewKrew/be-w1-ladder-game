package domain;

import java.util.List;

public class LadderLine {
    private final List<Piece> pieces;

    public LadderLine(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getLadderLinePieces() {
        return pieces;
    }
}
