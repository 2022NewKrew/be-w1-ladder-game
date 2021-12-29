package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.util.CheckBound;

public class Member {
    public static final int INIT = 3;
    public static final int MIN = 2;
    public static final int MAX = 10;

    private int member;

    public int getMember() {
        return member;
    }

    public void setMember(final int member) {
        try {
            CheckBound.checkIntBound(member, MIN, MAX);
        } catch (IndexOutOfBoundsException e) {
            this.member = INIT;
            throw e;
        }

        this.member = member;
    }
}
