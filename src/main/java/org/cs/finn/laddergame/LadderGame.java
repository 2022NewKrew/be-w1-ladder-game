package org.cs.finn.laddergame;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.stringvalues.Members;
import org.cs.finn.laddergame.domain.stringvalues.Rewards;
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
        final Members members = userInput.requestMembers();
        final Rewards rewards = userInput.requestRewards(members);
        final Ladder ladder = userInput.requestLadder(sRand, members);
        // 사다리 출력
        memberView.print(members);
        ladderView.print(ladder);
    }
}
