package com.chanminkim.w1;

import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.view.LadderConverter;

import java.util.Random;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Integer numberOfPlayers, Integer heightOfLadder, Random random) {
        this.ladder = new Ladder(numberOfPlayers, heightOfLadder, random);
    }

    public String buildLadder() {
        return LadderConverter.convertToString(ladder);
    }
}
