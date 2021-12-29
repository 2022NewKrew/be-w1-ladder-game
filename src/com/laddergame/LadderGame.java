package com.laddergame;

import java.util.List;

public class LadderGame {
    public Lines lines;

    public LadderGame(int participantNumber, int ladderHeight) {
        lines = new Lines(participantNumber, ladderHeight);
    }

    public List<List<Boolean>> startGame() {
        return lines.addLadders();
    }
}
