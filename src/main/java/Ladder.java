package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;
    private List<LadderBrick> ladderBricks;


    Ladder(int height) {
        this.height = height;
        this.ladderBricks = IntStream.range(0, height).mapToObj(e -> new LadderBrick()).collect(Collectors.toList());
    }

    public LadderBrick getLadderBrickAt(int heightIdx) {
        return ladderBricks.get(heightIdx);
    }
}
