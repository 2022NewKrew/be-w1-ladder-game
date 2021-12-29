package com.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines valueOf(int participantNumber, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.valueOf(participantNumber));
        }
        return new Lines(lines);
    }

    public List<List<Boolean>> getLines() {
        return lines.stream().map(Line::getLine).collect(Collectors.toList());
    }
}
