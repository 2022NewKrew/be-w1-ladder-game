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
    private static final String memberTerminator = "춘식이";
    private static final String memberRetryer = "무지";
    private static final String memberAll = Member.ALL.toString();

    private final Scanner sc = new Scanner(System.in);

    public Members requestMembers() {
        System.out.println("참여할 사람 이름을 [" + Members.SEPARATOR + "]로 구분해서 입력하세요. [" + Members.MIN + " ~ " + Members.MAX + "명]");
        System.out.println(Member.MSG_ALLOWED_CHAR + "만 사용해 한 사람 당 " + Member.WIDTH + "자 이하로 써주세요.");

        final Members members = getMembersFromInput();
        System.out.println("게임에 참여하는 사람 목록: " + members.getList());
        System.out.println();
        return members;
    }

    private Members getMembersFromInput() {
        try {
            return new Members(sc.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("유효한 입력 값의 개수가 제한 범위[" + Members.MIN + ", " + Members.MAX + "]를 벗어났으므로");
            System.out.println("기본 값 " + Members.DEFAULT_MEMBER_LIST + "을 사용합니다");
        }

        return Members.getDefault();
    }

    public Rewards requestRewards(final Members members) {
        final int request = members.getList().size();
        System.out.println("보상 목록을 [" + Rewards.SEPARATOR + "]로 구분해서 입력하세요. [" + request + "개]");
        System.out.println(Reward.MSG_ALLOWED_CHAR + "만 사용해 보상마다 " + Reward.WIDTH + "자 이하로 써주세요.");
        System.out.println("입력 값 중 유효한 값의 개수가 " + request + "개보다 부족한 경우 \"X\"로 채우며");
        System.out.println(request + "개 보다 많은 경우 " + request + "개 뒤의 값들을 지웁니다");

        final Rewards rewards = getRewardsFromInput(members.getList().size());
        System.out.println("보상 목록: " + rewards.getList());
        System.out.println();
        return rewards;
    }

    private Rewards getRewardsFromInput(final int requestSize) {
        try {
            return new Rewards(sc.nextLine().trim(), requestSize);
        } catch (IllegalArgumentException e) {
            System.out.println("유효한 입력 값의 개수가 입력 허용 범위[" + Rewards.MIN + ", " + Rewards.MAX + "]를 벗어났으므로");
            System.out.println("기본 값 " + Rewards.DEFAULT_REWARD_LIST + "을 기준으로 사람 수 만큼 조절 후 사용합니다");
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
        System.out.println();

        return new Ladder(sRand, ladderHeight, members);
    }

    private LadderHeight getLadderHeightFromInput() {
        try {
            return new LadderHeight(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값 입력으로 기본 값 (" + LadderHeight.INIT + ")을 사용합니다");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("제한 범위[" + LadderHeight.MIN + ", " + LadderHeight.MAX + "]를 벗어났으므로 " +
                    "기본 값 (" + LadderHeight.INIT + ")을 사용합니다");
        }

        return LadderHeight.getDefault();
    }

    public Member requestMember(final Members members) {
        if (members == null) {
            throw new RuntimeException("Members is null!");
        }

        Member member = Member.NONE;
        while (member.isNone()) {
            System.out.println("결과를 보고 싶은 사람의 이름을 입력하세요 " + members.getList());
            System.out.println(memberAll + "를 입력해 모든 결과를 출력할 수 있습니다");
            System.out.println(memberRetryer + "를 입력해 새 사다리를 만들거나");
            System.out.println(memberTerminator + "를 입력해 종료할 수 있습니다");

            member = getMemberFromInput(members);
            System.out.println();
        }
        return member;
    }

    private Member getMemberFromInput(final Members members) {
        final String input = sc.nextLine().trim();
        final Member reserved = getReservedMember(input);
        if (!reserved.isNone()) {
            return reserved;
        }

        final Member member = members.find(input);
        if (member.isNone()) {
            System.out.println("입력한 멤버를 찾을 수 없습니다");
        }
        return member;
    }

    private Member getReservedMember(final String input) {
        if (memberRetryer.equals(input)) {
            return Member.RETRYER;
        }
        if (memberTerminator.equals(input)) {
            return Member.TERMINATOR;
        }
        if (memberAll.equals(input)) {
            return Member.ALL;
        }
        return Member.NONE;
    }
}
