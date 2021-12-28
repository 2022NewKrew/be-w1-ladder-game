package org.cs.finn.laddergame.domain;

public class Input {
    public static final int INIT_MEMBER = 3;
    public static final int MIN_MEMBER = 2;
    public static final int MAX_MEMBER = 10;
    public static final int INIT_LADDER_HEIGHT = 5;
    public static final int MIN_LADDER_HEIGHT = 1;
    public static final int MAX_LADDER_HEIGHT = 30;

    private int member;
    private int ladderHeight;

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }
}
