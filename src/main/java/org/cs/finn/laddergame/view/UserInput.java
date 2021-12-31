package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.stringvalues.Member;
import org.cs.finn.laddergame.domain.stringvalues.Members;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.cs.finn.laddergame.domain.stringvalues.Reward;
import org.cs.finn.laddergame.domain.stringvalues.Rewards;

import java.security.SecureRandom;
import java.util.Scanner;

public class UserInput {
    private final Scanner sc = new Scanner(System.in);

    public Members requestMembers() {
        System.out.println("참여할 사람 이름을 [" + Members.SEPARATOR + "]로 구분해서 입력하세요. [" + Members.MIN + " ~ " + Members.MAX + "명]");
        System.out.println(Member.MSG_ALLOWED_CHAR + "만 사용해 한 사람 당 " + Member.WIDTH + "자 이하로 써주세요.");

        final Members members = getMembersFromInput();
        System.out.println("게임에 참여하는 사람 목록: " + members.getList());
        return members;
    }

    private Members getMembersFromInput() {
        try {
            return new Members(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("유효한 입력 값의 개수가 제한 범위[" + Members.MIN + ", " + Members.MAX + "]를 벗어났으므로 " +
                    "기본 값 " + Members.DEFAULT_MEMBER_LIST + "을 사용합니다");
        }

        return Members.getDefault();
    }

    public Rewards requestRewards(final Members members) {
        System.out.println("보상 목록을 [" + Rewards.SEPARATOR + "]로 구분해서 입력하세요. [" + members.getList().size() + "개]");
        System.out.println(Reward.MSG_ALLOWED_CHAR + "만 사용해 보상마다 " + Reward.WIDTH + "자 이하로 써주세요.");

        final Rewards rewards = getRewardsFromInput(members.getList().size());
        System.out.println("보상 목록: " + rewards.getList());
        return rewards;
    }

    private Rewards getRewardsFromInput(final int requestSize) {
        try {
            return new Rewards(sc.nextLine(), requestSize);
        } catch (IllegalArgumentException e) {
            System.out.println("유효한 입력 값의 개수가 제한 범위[" + Rewards.MIN + ", " + Rewards.MAX + "]를 벗어났으므로 " +
                    "기본 값 " + Rewards.DEFAULT_REWARD_LIST + "을 기준으로 사람 수 만큼 조절 후 사용합니다");
        }

        return Rewards.getDefault(requestSize);
    }

    public Ladder requestLadder(final SecureRandom sRand, final Members members) {
        if (sRand == null) {
            throw new RuntimeException("SecureRandom is null!");
        }
        if (members == null) {
            throw new RuntimeException("Members is null!");
        }

        System.out.println("최대 사다리 높이는 몇 개인가요? [" + LadderHeight.MIN + ", " + LadderHeight.MAX + "]");
        final LadderHeight ladderHeight = getLadderHeightFromInput();

        return new Ladder(sRand, ladderHeight, members);
    }

    private LadderHeight getLadderHeightFromInput() {
        try {
            return new LadderHeight(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값 입력으로 기본 값 (" + LadderHeight.INIT + ")을 사용합니다");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("제한 범위[" + LadderHeight.MIN + ", " + LadderHeight.MAX + "]를 벗어났으므로 " +
                    "기본 값 (" + LadderHeight.INIT + ")을 사용합니다");
        }

        return LadderHeight.getDefault();
    }
}
