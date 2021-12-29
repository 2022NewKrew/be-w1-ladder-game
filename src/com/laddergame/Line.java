package com.laddergame;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> hasLadders = new ArrayList<>();

    public int participantNumber;

    public Line(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public List<Boolean> addLadder() {
        for (int i = 0; i < participantNumber - 1; i++) {
            hasLadders.add(isLadderAddable());
        }
        return hasLadders;
    }

    private boolean isLadderAddable() {
        return !hasPreviousLadder() && RandomNumber.exceedsThreshold();
    }

    private boolean hasPreviousLadder() {
        if (hasLadders.size() == 0) return false;
        return hasLadders.get(hasLadders.size() - 1);
    }
}
