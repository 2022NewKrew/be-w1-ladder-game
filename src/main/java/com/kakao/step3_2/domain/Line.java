package com.kakao.step3_2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RAND = new Random();

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