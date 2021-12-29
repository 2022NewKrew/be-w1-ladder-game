package com.chanminkim.w1.service;

import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderLine;
import com.chanminkim.w1.model.LadderState;

import java.security.SecureRandom;
import java.util.Random;

public class LadderService {
    private final Random random;

    public LadderService() {
        this(new SecureRandom());
    }

    public LadderService(Random random) {
        this.random = random;
    }

    public Ladder buildLadder(Integer numberOfPlayers, Integer heightOfLadder) {
        Ladder ladder = new Ladder();
        int widthOfLadder = numberOfPlayers * 2 - 1;
        for (int i = 0; i < heightOfLadder; i++) {
            ladder.appendLine(buildLine(widthOfLadder));
        }
        return ladder;
    }

    private LadderLine buildLine(Integer width) {
        LadderLine line = new LadderLine();
        for (int i = 0; i < width - 1; i += 2) {
            line.appendState(LadderState.VERTICAL);
            line.appendState(buildPiece(line.isOccurredBefore()));
        }
        line.appendState(LadderState.VERTICAL);
        return line;
    }

    private LadderState buildPiece(boolean isOccurredBefore) {
        if (isOccurredBefore) {
            return LadderState.EMPTY;
        }
        return random.nextBoolean() ? LadderState.HORIZONTAL : LadderState.EMPTY;
    }
}
