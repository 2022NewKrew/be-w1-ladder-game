package com.kakao.step3_2.view;

import com.kakao.step3_2.domain.Ladder;

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

