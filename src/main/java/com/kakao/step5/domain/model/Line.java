package com.kakao.step5.domain.model;

import java.util.ArrayList;

public class Line {
    private final Points points;

    public Line(int countOfPeople) {
        points = new Points(new ArrayList<>());
        points.makeRandomLines(countOfPeople);
    }

    public int checkNextIndex(int personIndex) {
        return points.checkNextIndex(personIndex);
    }

    @Override
    public String toString() {
        return points.toString() + "\n";
    }
}