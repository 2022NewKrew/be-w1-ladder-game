package com.chanminkim.w1.controller;

import com.chanminkim.w1.model.LadderGame;
import com.chanminkim.w1.service.LadderGameService;

public class LadderGameController {
    private final LadderGameService service = new LadderGameService();

    public LadderGame buildLadderGame(LadderGameDTO dto) {
        return service.buildLadderGame(dto);
    }
}
