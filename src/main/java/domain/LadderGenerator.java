package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class LadderGenerator {
    private final int playerNums;
    private final int maximumLadderHeight;

    public LadderGenerator(int playerNums, int maximumLadderHeight) {
        this.playerNums = playerNums;
        this.maximumLadderHeight = maximumLadderHeight;
    }

    public Ladder createLadder() {
        List<LadderLine> ladder = new ArrayList<>(maximumLadderHeight);
        Stream.generate(this::createLadderLine)
                .limit(maximumLadderHeight)
                .forEach(ladder::add);
        return new Ladder(ladder);
    }


    private LadderLine createLadderLine() {
        List<Piece> pieces = new ArrayList<>(playerNums);
        Stream.generate(this::createRowOrSpace)
                .limit(playerNums - 1)
                .forEachOrdered(pieces::add);
        return new LadderLine(pieces);
    }

    private Piece createRowOrSpace() {
        Random random = new Random();
        System.out.println("안녕하세요");
        System.out.print(random.nextBoolean());
        return (random.nextBoolean()) ? new Piece(true) : new Piece(false);
    }
}
