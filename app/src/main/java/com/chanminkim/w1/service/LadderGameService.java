package com.chanminkim.w1.service;

import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderState;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class LadderGameService {
    private final Random random;

    public LadderGameService() {
        this(new SecureRandom());
    }

    public LadderGameService(Random random) {
        this.random = random;
    }

    public Ladder buildLadder(LadderGameDTO dto) {
        int widthOfLadder = dto.getNumberOfPlayers() * 2 - 1;
        return new Ladder(Arrays.stream(new LadderState[dto.getHeightOfLadder()][widthOfLadder])
                .map(this::buildLine)
                .toArray(LadderState[][]::new));
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
}
