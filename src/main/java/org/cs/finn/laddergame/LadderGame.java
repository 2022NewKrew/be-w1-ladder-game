package org.cs.finn.laddergame;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.stringvalues.Member;
import org.cs.finn.laddergame.domain.stringvalues.Members;
import org.cs.finn.laddergame.domain.stringvalues.Reward;
import org.cs.finn.laddergame.domain.stringvalues.Rewards;
import org.cs.finn.laddergame.view.LadderView;
import org.cs.finn.laddergame.view.StringValuesView;
import org.cs.finn.laddergame.view.UserInput;

import java.security.SecureRandom;

public class LadderGame {
    private final SecureRandom sRand = new SecureRandom();

    private final UserInput userInput = new UserInput();
    private final LadderView ladderView = new LadderView();
    private final StringValuesView stringValuesView = new StringValuesView();

    public LadderGame() {
        System.out.println("--- 사다리 게임 ---");
    }

    public void run() {
        Member member = Member.RETRYER;

        while (member.isNotTerminator()) {
            final Members members = userInput.requestMembers();
            final Rewards rewards = userInput.requestRewards(members);
            final Ladder ladder = userInput.requestLadder(sRand, members);

            printLadder(members, ladder, rewards);
            member = getMemberAndPrintLadderWithReward(members, ladder, rewards);
        }
    }

    private void printLadder(final Members members, final Ladder ladder, final Rewards rewards) {
        stringValuesView.print(members, Member.WIDTH);
        ladderView.print(ladder);
        stringValuesView.print(rewards, Reward.WIDTH);
    }

    private Member getMemberAndPrintLadderWithReward(final Members members, final Ladder ladder, final Rewards rewards) {
        Member member = userInput.requestMember(members);
        while (member.isNotTerminator() || member.isNotRetryer()) {
            printLadderWithReward(members, ladder, rewards, member);
            member = userInput.requestMember(members);
        }
        return member;
    }

    private void printLadderWithReward(
            final Members members,
            final Ladder ladder,
            final Rewards rewards,
            final Member member
    )
    {
        stringValuesView.print(members, Member.WIDTH);
        final int rewardIdx = ladderView.printWithRewardPath(ladder, members, member);
        stringValuesView.print(rewards, Reward.WIDTH);
        stringValuesView.printReward(member, rewards, rewardIdx);
    }
}
