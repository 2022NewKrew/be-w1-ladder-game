package com.kakao.step3.model;

import com.kakao.step3.domain.Validator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPeople) {
        points = new ArrayList<>();

        for (int i = 0; i < countOfPeople - 1; i++) {
            points.add(Validator.checkLine(points, i));
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }


}