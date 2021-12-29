package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.util.Checker;

public class Member {
    public static final int INIT = 3;
    public static final int MIN = 2;
    public static final int MAX = 10;

    private int member;

    public Member() {
        Checker.checkIntMinMaxInit(INIT, MIN, MAX);
    }

    public int getMember() {
        return member;
    }

    public void setMember(final int member) {
        Checker.checkIntBound(member, MIN, MAX);
        this.member = member;
    }
}
