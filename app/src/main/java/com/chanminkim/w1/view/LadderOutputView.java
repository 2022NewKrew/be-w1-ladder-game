package com.chanminkim.w1.view;

import com.chanminkim.w1.controller.LadderGameController;
import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.model.Ladder;

public class LadderOutputView {
    private final LadderGameController controller = new LadderGameController();
    private final LadderGameDTO dto;

    public LadderOutputView(LadderGameDTO dto) {
        this.dto = dto;
    }

    public void printLadder() {
        Ladder ladder = controller.buildLadder(this.dto);
        System.out.println(LadderConverter.convertToString(ladder));
    }
}
