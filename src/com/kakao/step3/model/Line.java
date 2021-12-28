package com.kakao.step3.model;

import com.kakao.step3.domain.Validator;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> points;

    public Line(int countOfPeople) {
        points = new ArrayList<>();

        for (int i = 0; i < countOfPeople - 1; i++) {
            points.add(Validator.checkLine(points, i));
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }


}