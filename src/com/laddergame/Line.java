package com.laddergame;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> hasLadders = new ArrayList<>();

    public int participantNumber;

    public Line(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public List<Boolean> startEachRound() {
        for (int i = 0; i < participantNumber - 1; i++) {
            hasLadders.add(hasLadderOrNot());
        }
        return hasLadders;
    }

    private boolean hasLadderOrNot() {
        return RandomNumber.exceedsThreshold();
    }
}
