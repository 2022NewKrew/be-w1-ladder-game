package com.chanminkim.w1.controller;

import com.chanminkim.w1.model.Ladder;

public class LadderGameController {
    public Ladder buildLadder(LadderGameDTO dto) {
        return new Ladder(dto.getNumberOfPlayers(), dto.getHeightOfLadder(), dto.getRandom());
    }
}
