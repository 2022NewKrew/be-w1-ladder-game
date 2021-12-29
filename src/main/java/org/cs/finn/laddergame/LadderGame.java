package org.cs.finn.laddergame;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.view.LadderView;
import org.cs.finn.laddergame.view.UserInput;

import java.security.SecureRandom;

public class LadderGame {
    private final SecureRandom sRand = new SecureRandom();

    private final UserInput userInput = new UserInput();
    private final LadderView ladderView = new LadderView();
    private final Ladder ladder = new Ladder(sRand);

    public LadderGame() {
        System.out.println("--- 사다리 게임 ---");
    }

    public void run() {
        // 사용자로부터 사다리 생성에 필요한 값을 받음
        userInput.requestInput();
        // 사다리 생성
        ladder.build(userInput.getInput());
        // 사다리 출력
        ladderView.print(ladder);
        // 종료 전에 Scanner 닫기
        userInput.closeScanner();
    }
}
