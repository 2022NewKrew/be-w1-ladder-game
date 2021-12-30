package org.cs.finn.laddergame.domain.ladder;

import org.cs.finn.laddergame.util.Checker;

public final class LadderHeight {
    public static final int INIT = 5;
    public static final int MIN = 1;
    public static final int MAX = 30;

    private final int ladderHeight;

    public LadderHeight(final String ladderHeightString)
            throws IndexOutOfBoundsException, NumberFormatException {
        Checker.checkIntMinMaxInit(INIT, MIN, MAX);
        if (ladderHeightString == null) {
            throw new RuntimeException("ladderHeightString is null!");
        }

        int temp = Integer.parseInt(ladderHeightString, 10);
        Checker.checkIntBound(temp, MIN, MAX);
        ladderHeight = temp;
    }

    public static LadderHeight getDefault() {
        return new LadderHeight(String.valueOf(INIT));
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
