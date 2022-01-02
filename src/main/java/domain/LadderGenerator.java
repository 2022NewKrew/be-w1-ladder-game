package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGenerator {
    private final int playerNums;
    private final int maximumLadderHeight;
    private static final Random random = new Random();

    public LadderGenerator(int playerNums, int maximumLadderHeight) {
        this.playerNums = playerNums;
        this.maximumLadderHeight = maximumLadderHeight;

    }

    public Ladder createLadder() {
        List<LadderLine> ladder = Stream.generate(this::createLadderLine)
                .limit(maximumLadderHeight)
                .collect(Collectors.toList());
        return new Ladder(ladder);
    }

    private LadderLine createLadderLine() {
        List<Piece> pieces = new ArrayList<>(playerNums - 1);
        pieces.add(createRowOrSpace(false));
        for (int indexPieceBefore = 0; indexPieceBefore < playerNums - 2; indexPieceBefore++) {
            pieces.add(createRowOrSpace(pieces.get(indexPieceBefore).getPiece()));
        }
        pieces.add(new Piece(false));
        return new LadderLine(pieces);
    }

    private Piece createRowOrSpace(boolean isRowBefore) {
        if (isRowBefore) {
            return new Piece(false);
        }
        return (random.nextBoolean()) ? new Piece(true) : new Piece(false);
    }
}
