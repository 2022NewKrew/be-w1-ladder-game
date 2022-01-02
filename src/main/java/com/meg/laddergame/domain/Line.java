package com.meg.laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random random = new Random();
    private final List<Boolean> points = new ArrayList<>();

    protected Line() {
    }

    public Line(int countOfPerson) {
        setLine(countOfPerson);
    }

    private void setLine(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(getBridge(i));
        }
    }

    protected Boolean getBridge(int i) {
        if (i > 0 && points.get(i - 1)) {
            return false;
        }
        return random.nextBoolean();
    }

    public List<Boolean> getpoints() {
        return points;
    }

}
