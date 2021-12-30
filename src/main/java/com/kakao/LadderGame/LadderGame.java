package com.kakao.LadderGame;

import com.kakao.model.Ladder;
import com.kakao.model.RandomStrategy;

public class LadderGame {

    private Ladder ladder;

    // 사다리 만들기
    public void generateLadder(RandomStrategy<Boolean> randomStrategy) {
        this.ladder = LadderIO.inputLadderData(randomStrategy);
    }

    // 사다리 출력
    public void printLadder() {
        LadderIO.printLadder(this.ladder);
    }

    // 메인
    public void play(RandomStrategy<Boolean> randomStrategy) {
        this.generateLadder(randomStrategy);
        this.printLadder();
    }
}
