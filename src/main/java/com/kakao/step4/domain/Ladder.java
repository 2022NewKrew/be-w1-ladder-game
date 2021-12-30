package com.kakao.step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Names names;
    private final List<Line> lines;

    public Ladder(Names names, int countOfLines) {
        this.names = names;
        this.lines = new ArrayList<>();

        for (int i = 0, countOfPeople = names.getSize(); i < countOfLines; i++) {
            lines.add(new Line(countOfPeople));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.names.toString());

        for (Line line : lines) {
            sb.append(line.toString());
        }

        return sb.toString();
    }
}