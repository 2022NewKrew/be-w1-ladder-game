package org.cs.finn.laddergame.domain;

import java.util.Scanner;

public class InputParameter {
    private static final int INIT_MEMBER = 3;
    private static final int MIN_MEMBER = 2;
    private static final int MAX_MEMBER = 10;

    private static final int INIT_LADDER_HEIGHT = 5;
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 30;

    private final Scanner sc;
    private int member;
    private int ladderHeight;

    public InputParameter() {
        sc = new Scanner(System.in);
    }

    public void closeScanner() {
        sc.close();
    }

    public void requestMember() {
        System.out.println("참여할 사람은 몇 명인가요?");

        try {
            member = sc.nextInt(10);
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("잘못된 값으로 기본 값 " + INIT_MEMBER + "명을 사용합니다");
            member = INIT_MEMBER;
        }

        final int fixed = CheckBound.checkIntBound(member, MIN_MEMBER, MAX_MEMBER);
        if (member != fixed) {
            System.out.println(
                    "제한 범위[" + MIN_MEMBER + ", " + MAX_MEMBER + "]를 벗어났으므로 " +
                    "수정된 " + fixed + "명을 사용합니다"
            );
            member = fixed;
        }
    }

    public int getMember() {
        return this.member;
    }

    public void requestLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            ladderHeight = sc.nextInt(10);
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("잘못된 값으로 기본 값 " + INIT_LADDER_HEIGHT + "개를 사용합니다");
            ladderHeight = INIT_MEMBER;
        }

        final int fixed = CheckBound.checkIntBound(ladderHeight, MIN_LADDER_HEIGHT, MAX_LADDER_HEIGHT);
        if (ladderHeight != fixed) {
            System.out.println(
                    "제한 범위[" + MIN_LADDER_HEIGHT + ", " + MAX_LADDER_HEIGHT + "]를 벗어났으므로 " +
                    "수정된 " + fixed + "개를 사용합니다"
            );
            ladderHeight = fixed;
        }
    }

    public int getLadderHeight() {
        return this.ladderHeight;
    }
}
