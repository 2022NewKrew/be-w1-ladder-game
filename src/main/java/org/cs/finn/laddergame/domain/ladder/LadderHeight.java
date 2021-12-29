package org.cs.finn.laddergame.domain.ladder;

import org.cs.finn.laddergame.util.Checker;

public final class LadderHeight {
    public static final int INIT = 5;
    public static final int MIN = 1;
    public static final int MAX = 30;

    private int ladderHeight;

    public LadderHeight() {
        Checker.checkIntMinMaxInit(INIT, MIN, MAX);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(final int ladderHeight) {
        Checker.checkIntBound(ladderHeight, MIN, MAX);
        this.ladderHeight = ladderHeight;
    }
}
