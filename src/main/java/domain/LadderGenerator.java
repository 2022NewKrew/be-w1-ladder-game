package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGenerator {
    Random random = new Random();
//    private static final Boolean
//    private static final Double MATH_RANDOM_PERCENT = 0.6;

    public Ladder createLadder(Integer playersNum, Integer maximumLadderHeight) {
        List<LadderLine> ladder = new ArrayList<>();

        IntStream.range(0, maximumLadderHeight).forEach(i -> ladder.add(new LadderLine(createLadderLine(playersNum))));
//        for (int i = 0; i < maximumLadderHeight; i++) {
//            ladder.add(new LadderLine(createLadderLine(playersNum)));
//        }
        return new Ladder(ladder);
    }

    private List<LadderLinePiece> createLadderLine(Integer playersNum) {
        List<LadderLinePiece> pieces = new ArrayList<>();
        for (int i = 0; i < playersNum * 2 - 1; i++) {
            pieces.add(createLadderLinePiece(i));
        }
        return pieces;
    }

    private LadderLinePiece createLadderLinePiece(int ladderLinePieceIndex) {
        if (ladderLinePieceIndex % 2 == 0) {
            return LadderLinePiece.VERTICAL;
        }
        return (random.nextBoolean()) ? LadderLinePiece.EMPTY : LadderLinePiece.HORIZONTAL;
    }
}
