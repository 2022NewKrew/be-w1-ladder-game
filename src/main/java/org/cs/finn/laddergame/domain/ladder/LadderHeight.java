package org.cs.finn.laddergame.domain.ladder;

import org.cs.finn.laddergame.util.CheckBound;

public final class LadderHeight {
    public static final int INIT = 5;
    public static final int MIN = 1;
    public static final int MAX = 30;

    private int ladderHeight;

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(final int ladderHeight) {
        try {
            CheckBound.checkIntBound(ladderHeight, MIN, MAX);
        } catch (IndexOutOfBoundsException e) {
            this.ladderHeight = INIT;
            throw e;
        }

        this.ladderHeight = ladderHeight;
    }
}
