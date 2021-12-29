package com.kakao.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
