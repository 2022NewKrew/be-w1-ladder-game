package com.kakaocorp.laddergame.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Line {

    private final int countOfPerson;
    private static final List<Boolean> lineItems = Arrays.asList(false, true);
    private static final Random rand = new Random();
    private List<Boolean> lineTypes = new ArrayList<>();

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        if (countOfPerson < 1) {
            return;
        }

        makeLineTypes();
    }

    private void makeLineTypes() {
        Boolean before = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            Boolean falseOrTrue = getFalseOrTrue(before);
            lineTypes.add(falseOrTrue);
            before = falseOrTrue;
        }
    }

    public Boolean getFalseOrTrue(Boolean before) {
        if (before == (lineItems.get(1))) {
            return lineItems.get(0);
        }

        return lineItems.get(rand.nextInt(lineItems.size()));
    }

    public List<Boolean> getLineTypes() {
        return lineTypes;
    }
}
