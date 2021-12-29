package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Member;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput {
    private final Scanner sc = new Scanner(System.in);

    public void closeScanner() {
        sc.close();
    }

    private int requestInt(
            final String msg,
            final int min,
            final int max,
            final int init
    )
    {
        System.out.println(msg + " [" + min + ", " + max + "]");

        try {
            return sc.nextInt(10);
        } catch (NoSuchElementException e) {
            System.out.println("잘못된 값 입력으로 기본 값 (" + init + ")을 사용합니다");
        }

        return init;
    }

    private void printErrOutOfIntBound(
            final int min,
            final int max,
            final int init
    )
    {
        System.out.println("제한 범위[" + min + ", " + max + "]를 벗어났으므로 기본 값 (" + init + ")을 사용합니다");
    }

    public void requestMember(final Member member) {
        if (member == null) {
            throw new RuntimeException("Member is null!");
        }

        final int input = requestInt(
                "참여할 사람은 몇 명인가요?",
                Member.MIN,
                Member.MAX,
                Member.INIT
        );

        try {
            member.setMember(input);
        } catch (IndexOutOfBoundsException e) {
            printErrOutOfIntBound(Member.MIN, Member.MAX, Member.INIT);
        }
    }

    public void requestLadderHeight(final LadderHeight ladderHeight) {
        if (ladderHeight == null) {
            throw new RuntimeException("LadderHeight is null!");
        }

        final int input = requestInt(
                "최대 사다리 높이는 몇 개인가요?",
                LadderHeight.MIN,
                LadderHeight.MAX,
                LadderHeight.INIT
        );

        try {
            ladderHeight.setLadderHeight(input);
        } catch (IndexOutOfBoundsException e) {
            printErrOutOfIntBound(LadderHeight.MIN, LadderHeight.MAX, LadderHeight.INIT);
        }
    }
}
