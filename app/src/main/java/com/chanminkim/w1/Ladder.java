package com.chanminkim.w1;

import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private final Random random;
    private final LadderState[][] map;

    public Ladder(Integer numberOfPlayers, Integer heightOfLadder, Random random) {
        this.random = random;
        int widthOfLadder = numberOfPlayers * 2 - 1;
        this.map = buildMap(new LadderState[heightOfLadder][widthOfLadder]);
    }

    private LadderState[][] buildMap(LadderState[][] map) {
        return Arrays.stream(map)
                .map(this::buildLine)
                .toArray(LadderState[][]::new);
    }

    private LadderState[] buildLine(LadderState[] line) {
        for (int i = 1; i < line.length - 1; i += 2) {
            line[i - 1] = LadderState.VERTICAL;
            boolean isOccurredBefore = i > 1 && line[i - 2].equals(LadderState.HORIZONTAL);
            line[i] = buildPiece(isOccurredBefore);
        }
        line[line.length - 1] = LadderState.VERTICAL;
        return line;
    }

    private LadderState buildPiece(boolean isOccurredBefore) {
        if (isOccurredBefore) {
            return LadderState.EMPTY;
        }
        return random.nextBoolean() ? LadderState.HORIZONTAL : LadderState.EMPTY;
    }

    public LadderState[][] getMap() {
        return map;
    }
}
