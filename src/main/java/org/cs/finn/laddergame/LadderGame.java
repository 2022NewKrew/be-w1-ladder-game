package org.cs.finn.laddergame;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.Member;
import org.cs.finn.laddergame.view.LadderView;
import org.cs.finn.laddergame.view.MemberView;
import org.cs.finn.laddergame.view.UserInput;

import java.security.SecureRandom;

public class LadderGame {
    private final SecureRandom sRand = new SecureRandom();

    private final UserInput userInput = new UserInput();
    private final LadderView ladderView = new LadderView();
    private final MemberView memberView = new MemberView();

    public LadderGame() {
        System.out.println("--- 사다리 게임 ---");
    }

    public void run() {
        // 사용자로부터 사다리 생성에 필요한 값을 입력 받아 사다리 객체 생성
        final Member member = userInput.requestMember();
        final Ladder ladder = userInput.requestLadder(sRand, member);
        // 사다리 출력
        //memberView.print(member);
        ladderView.print(ladder);
        // 종료 전에 Scanner 닫기
        userInput.closeScanner();
    }
}
