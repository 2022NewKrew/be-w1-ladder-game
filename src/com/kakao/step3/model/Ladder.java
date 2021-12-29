package com.kakao.step3.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPeople, int countOfLines) {
        lines = new ArrayList<>();

        for (int i = 0; i < countOfLines; i++) {
            lines.add(new Line(countOfPeople));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}