package com.kakao.step2.model;

import java.util.ArrayList;

public class Ladder {
    private final ArrayList<Line> lines;

    public Ladder(int countOfPeople, int countOfLines) {
        lines = new ArrayList<>();

        for (int i = 0; i < countOfLines; i++) {
            lines.add(new Line(countOfPeople));
        }
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
}