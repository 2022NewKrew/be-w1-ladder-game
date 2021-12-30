package com.kakao.LadderGame;

import com.kakao.model.Ladder;

public class LadderGame {

    private Ladder ladder;

    public void generateLadder() {
        this.ladder = LadderIO.inputLadderData();
    }

    // 사다리 출력
    public void printLadder() {
        LadderIO.printLadder(this.ladder);
    }

    // 메인
    public void play() {
        this.generateLadder();
        this.printLadder();
    }
}
