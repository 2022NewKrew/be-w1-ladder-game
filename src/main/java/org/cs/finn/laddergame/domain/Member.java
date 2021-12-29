package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.util.Checker;

import java.util.List;

public class Member {
    public static final int INIT = 3;
    public static final int MIN = 2;
    public static final int MAX = 10;

    private static final List<String> DEFAULT_MEMBER = List.of("Ryan", "Con", "Muzi");

    private final int member;

    public Member(final String memberString)
            throws IndexOutOfBoundsException, NumberFormatException
    {
        Checker.checkIntMinMaxInit(INIT, MIN, MAX);

        int temp = Integer.parseInt(memberString, 10);
        Checker.checkIntBound(temp, MIN, MAX);
        member = temp;
    }

    public static Member getDefault() {
        return new Member(String.valueOf(INIT));
    }

    public int getMember() {
        return member;
    }
}
