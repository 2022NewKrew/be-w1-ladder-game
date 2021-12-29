package com.chanminkim.w1.controller;

import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.service.LadderGameService;

public class LadderGameController {
    private final LadderGameService service = new LadderGameService();

    public Ladder buildLadder(LadderGameDTO dto) {
        return service.buildLadder(dto);
    }
}
