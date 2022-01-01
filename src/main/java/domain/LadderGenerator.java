package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderGenerator {
    Random random = new Random();
//    private static final Boolean
//    private static final Double MATH_RANDOM_PERCENT = 0.6;

    public Ladder createLadder(Integer playersNum, Integer maximumLadderHeight) {
        List<LadderLine> ladder = new ArrayList<>();

//        Stream.generate(this::createLadderLine)
//                .limit(maximumLadderHeight)
//                .forEachOrdered(ladder::add);

        IntStream.range(0, maximumLadderHeight)
                .forEach(i -> ladder.add(new LadderLine(createLadderLine(playersNum))));
//        for (int i = 0; i < maximumLadderHeight; i++) {
//            ladder.add(new LadderLine(createLadderLine(playersNum)));
//        }
        return new Ladder(ladder);
    }

    private List<Piece> createLadderLine(Integer playersNum) {
        List<Piece> pieces = new ArrayList<>();

//        Stream.generate(LadderGenerator::createLadderLinePiece)
//                .limit(playersNum * 2 - 1)
//                .forEachOrdered(pieces::add);

        IntStream.range(0, playersNum * 2 - 1)
                .forEach(i -> pieces.add(createLadderLinePiece(i)));
        //        for (int i = 0; i < playersNum * 2 - 1; i++) {
//            pieces.add(createLadderLinePiece(i));
//        }
        return pieces;
    }

    private Piece createLadderLinePiece(int ladderLinePieceIndex) {
        if (ladderLinePieceIndex % 2 == 0) {
            return Piece.VERTICAL;
        }
        return (random.nextBoolean()) ? Piece.EMPTY : Piece.HORIZONTAL;
    }
}
