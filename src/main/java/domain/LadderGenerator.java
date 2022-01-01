package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGenerator {
    private final int playerNums;
    private final int maximumLadderHeight;

    public LadderGenerator(int playerNums, int maximumLadderHeight) {
        this.playerNums = playerNums;
        this.maximumLadderHeight = maximumLadderHeight;
    }

    public Ladder createLadder() {
        List<LadderLine> ladder = new ArrayList<>();

//        Stream.generate(this::createLadderLine)
//                .limit(maximumLadderHeight)
//                .forEach(ladder::add);
//        List<LadderLine> ladder = Stream.of(this.createLadderLine(playersNum)).limit(maximumLadderHeight).forEach(la).collect(Collectors.toList());
//        List<LadderLine> ladder = Stream.of(this.createLadderLine(playersNum)).limit(maximumLadderHeight).collect(Collectors.toList());

        Stream.generate(this::createLadderLine)
                .limit(maximumLadderHeight)
                .forEachOrdered(ladder::add);

//        IntStream.range(0, maximumLadderHeight)
//                .forEach(i -> ladder.add(new LadderLine(createLadderLine(playersNum))));
//        for (int i = 0; i < maximumLadderHeight; i++) {
//            ladder.add(new LadderLine(createLadderLine(playersNum)));
//        }
        return new Ladder(ladder);
    }


    private LadderLine createLadderLine() {
//        Stream a = Stream.of(this.createRowOrSpace()).l

        List<Piece> pieces = new ArrayList<>();
        Stream.generate(this::createRowOrSpace)
                .limit(playerNums - 1)
                .forEachOrdered(pieces::add);
        return new LadderLine(pieces);


//        return new LadderLine(Stream.of(this.createRowOrSpace()).limit(playerNums - 1).collect(Collectors.toList()));
//        return new LadderLine(Stream.generate(this::createRowOrSpace).limit(playersNum - 1).collect(Collectors.toList()));
    }

    private Piece createRowOrSpace() {
        Random random = new Random();
        System.out.println("안녕하세요");
        System.out.print(random.nextBoolean());
        return (random.nextBoolean()) ? new Piece(true) : new Piece(false);
    }
}
