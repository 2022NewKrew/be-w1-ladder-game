package com.chanminkim.w1.service;

import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderLine;
import com.chanminkim.w1.model.LadderState;

import java.security.SecureRandom;
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
        Ladder ladder = new Ladder();
        int widthOfLadder = dto.getNumberOfPlayers() * 2 - 1;
        for (int i = 0; i < dto.getHeightOfLadder(); i++) {
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
