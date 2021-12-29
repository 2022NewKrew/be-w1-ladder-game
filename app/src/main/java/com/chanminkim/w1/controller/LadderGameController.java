package com.chanminkim.w1.controller;

import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.view.LadderConverter;

public class LadderGameController {
    private final Ladder ladder;

    public LadderGameController(LadderGameDTO dto) {
        this.ladder = new Ladder(dto.getNumberOfPlayers(), dto.getHeightOfLadder(), dto.getRandom());
    }

    public String buildLadder() {
        return LadderConverter.convertToString(ladder);
    }
}
