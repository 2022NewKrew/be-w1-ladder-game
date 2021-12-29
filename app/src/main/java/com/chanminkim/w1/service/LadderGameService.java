package com.chanminkim.w1.service;

import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.model.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderGameService {
    private final Random random;

    public LadderGameService() {
        this(new SecureRandom());
    }

    public LadderGameService(Random random) {
        this.random = random;
    }

    public LadderGame buildLadderGame(LadderGameDTO dto) {
        Ladder ladder = buildLadder(dto.getPlayers().size(), dto.getHeightOfLadder());
        List<Player> players = dto.getPlayers().stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
        return new LadderGame(players, ladder);
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
