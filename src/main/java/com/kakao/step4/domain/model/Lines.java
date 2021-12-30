package com.kakao.step4.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines() {
        lines = new ArrayList<>();
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public void addLines(int countOfPeople, int countOfLines) {
        for (int i = 0; i < countOfLines; i++) {
            lines.add(new Line(countOfPeople));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Line line : lines) {
            sb.append(line.toString());
        }

        return sb.toString();
    }
}
