package com.chanminkim.w1;

import java.util.Random;

public class LadderGame {
    private final Integer numberOfPlayers;
    private final Integer heightOfLadder;
    private final Random random;

    public LadderGame(Integer numberOfPlayers, Integer heightOfLadder, Random random) {
        this.numberOfPlayers = numberOfPlayers;
        this.heightOfLadder = heightOfLadder;
        this.random = random;
    }

    public String buildLadder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < heightOfLadder; i++) {
            builder.append(buildLine());
            builder.append('\n');
        }
        return builder.toString();
    }

    private String buildLine() {
        StringBuilder builder = new StringBuilder();
        boolean isOccurredBefore = false;
        for (int i = 0; i < numberOfPlayers - 1; i++) {
            builder.append(LadderState.VERTICAL.getValue());
            String piece = buildPiece(isOccurredBefore);
            isOccurredBefore = piece.equals(LadderState.HORIZONTAL.getValue());
            builder.append(piece);
        }
        builder.append(LadderState.VERTICAL.getValue());
        return builder.toString();
    }

    private String buildPiece(boolean isOccurredBefore) {
        if (isOccurredBefore) {
            return LadderState.EMPTY.getValue();
        }
        return random.nextBoolean() ? LadderState.HORIZONTAL.getValue() : LadderState.EMPTY.getValue();
    }
}
