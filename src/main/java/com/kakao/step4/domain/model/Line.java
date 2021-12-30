package com.kakao.step4.domain.model;

import java.util.ArrayList;

public class Line {
    private final Points points;

    public Line(int countOfPeople) {
        points = new Points(new ArrayList<>());
        points.makeRandomLines(countOfPeople);
    }

    @Override
    public String toString() {
        return points.toString() + "\n";
    }
}