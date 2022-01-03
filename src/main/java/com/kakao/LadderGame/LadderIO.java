package com.kakao.LadderGame;

import com.kakao.model.Ladder;
import com.kakao.random.RandomStrategy;

public class LadderIO {

    // 생성함수
    public static Ladder inputLadderData (RandomStrategy<Boolean> randomStrategy) {
        return LadderInput.inputLadderData(randomStrategy);
    }

    // 출력함수
    public static void printLadder(Ladder ladder) {
        // 사다리 전체 출력
        LadderOutput.printLadder(ladder);
    }
}
