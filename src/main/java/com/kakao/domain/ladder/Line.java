package com.kakao.domain.ladder;

import com.kakao.util.RandomUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Line drawLine(int width) {
        List<Boolean> points = new ArrayList<>();
        Boolean prev = Boolean.FALSE;
        for (int i = 0; i < width - 1; i++) {
            Boolean current = avoidOverlapping(prev, RandomUtil.nextBoolean());
            points.add(current);
            prev = current;
        }
        return new Line(points);
    }

    private static Boolean avoidOverlapping(Boolean prev, Boolean current) {
        return !prev && current;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
