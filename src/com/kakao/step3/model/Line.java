package com.kakao.step3.model;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> points;

    public Line(int countOfPeople) {
        points = new ArrayList<>();

        for (int i = 0; i < countOfPeople - 1; i++) {
            points.add(Math.random() > 0.5);
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}