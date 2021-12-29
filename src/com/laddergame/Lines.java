package com.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int participantNumber, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(participantNumber));
        }
    }

    public List<List<Boolean>> addLadders() {
        return lines.stream().map(Line::addLadder).collect(Collectors.toList());
    }
}
