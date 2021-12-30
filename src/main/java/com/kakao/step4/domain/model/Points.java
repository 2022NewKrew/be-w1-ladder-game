package com.kakao.step4.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Points {
    private static final String POINT_VERT = "|";
    private static final String POINT_HORI = "-----";
    private static final String POINT_EMP = "     ";
    private static final Random RAND = new Random();

    private final List<Boolean> points;

    public Points() {
        points = new ArrayList<>();
    }

    public Points(List<Boolean> points) {
        this.points = points;
    }

    public void makeRandomLines(int countOfPeople) {
        for (int i = 0; i < countOfPeople - 1; i++) {
            points.add(RAND.nextBoolean() && (i == 0 || !points.get(i - 1)));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(POINT_EMP);

        for (int i = 0, size = points.size(); i < 2 * size + 1; i++) {
            sb.append(convPointToString(i));
        }

        return sb.toString();
    }

    private String convPointToString(int i) {
        if (i % 2 == 0) return POINT_VERT;

        if (points.get((i - 1) / 2)) return POINT_HORI;

        return POINT_EMP;
    }
}
