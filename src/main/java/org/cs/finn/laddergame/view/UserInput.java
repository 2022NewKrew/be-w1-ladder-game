package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.Member;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;

import java.security.SecureRandom;
import java.util.Scanner;

public class UserInput {
    private final Scanner sc = new Scanner(System.in);

    public void closeScanner() {
        sc.close();
    }

    public Member requestMember() {
        System.out.println("참여할 사람 이름을 [" + Member.SEPARATOR + "]로 구분해서 입력하세요. [" + Member.MIN + " ~ " + Member.MAX + "명]");
        System.out.println("영문 대소문자와 숫자만 사용해 한 사람 당 5자 이하로 써주세요.");
        return getMemberFromInput();
    }

    private Member getMemberFromInput() {
        try {
            return new Member(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("유효한 입력 값의 개수가 제한 범위[" + Member.MIN + ", " + Member.MAX + "]를 벗어났으므로 " +
                    "기본 값 " + Member.DEFAULT_MEMBER + "을 사용합니다");
        }

        return Member.getDefault();
    }

    public Ladder requestLadder(final SecureRandom sRand, final Member member) {
        if (sRand == null) {
            throw new RuntimeException("SecureRandom is null!");
        }
        if (member == null) {
            throw new RuntimeException("Member is null!");
        }

        System.out.println("최대 사다리 높이는 몇 개인가요? [" + LadderHeight.MIN + ", " + LadderHeight.MAX + "]");
        final LadderHeight ladderHeight = getLadderHeightFromInput();

        return new Ladder(sRand, ladderHeight, member);
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
