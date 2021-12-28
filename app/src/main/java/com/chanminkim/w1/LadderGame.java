package com.chanminkim.w1;

import java.util.Random;

public class LadderGame {
    private final LadderMap ladderMap;

    public LadderGame(Integer numberOfPlayers, Integer heightOfLadder, Random random) {
        this.ladderMap = new LadderMap(numberOfPlayers, heightOfLadder, random);
    }

    public String buildLadder() {
        return LadderConverter.convertToString(ladderMap);
    }
}
