package com.kakao.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random random = new Random();
    private final List<Boolean> points;

    public Line() {
        points = new ArrayList<>();
    }

    public void draw(int width) {
        for (int i = 0; i < width - 1; i++) {
            points.add(random.nextBoolean());
            avoidOverlapping();
        }
    }

    private void avoidOverlapping() {
        if (points.size() < 2) {
            return;
        }

        Boolean previousPoint = points.get(points.size() - 2);
        Boolean currentPoint = points.get(points.size() - 1);
        if (currentPoint && previousPoint) {
            points.set(points.size() - 1, Boolean.FALSE);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boolean point : points) {
            sb.append(Mark.COL);
            sb.append(Mark.getMark(point));
        }
        sb.append(Mark.COL);
        return sb.toString();
    }
}
