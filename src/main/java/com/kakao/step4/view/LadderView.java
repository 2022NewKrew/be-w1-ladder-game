package com.kakao.step4.view;

import com.kakao.step4.domain.Ladder;

public class LadderView {
    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
        printLadder();
    }

    public void printLadder() {
        System.out.print(ladder);
    }
}

