package com.kakao.step3_2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String LADDER_VERT = "|";
    private static final String LADDER_HORI = "-----";
    private static final String LADDER_EMP = "     ";
    private static final Random RAND = new Random();

    private final List<Boolean> points;

    public Line(int countOfPeople) {
        points = new ArrayList<>();

        for (int i = 0; i < countOfPeople - 1; i++) {
            points.add(RAND.nextBoolean() && (i == 0 || !points.get(i - 1)));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(LADDER_EMP);

        for (int i = 0, size = points.size(); i < 2 * size + 1; i++) {
            sb.append(convPointToString(i));
        }

        sb.append("\n");

        return sb.toString();
    }

    private String convPointToString(int i) {
        if (i % 2 == 0) return LADDER_VERT;

        if (points.get((i - 1) / 2)) return LADDER_HORI;

        return LADDER_EMP;
    }
}