package com.kakao.step2.view;

import com.kakao.step2.domain.Ladder;

import java.util.ArrayList;

public class LadderView {
    private static final String LADDER_VERT = "|";
    private static final String LADDER_HORI = "-";
    private static final String LADDER_EMP = " ";

    private final int countOfPeople, countOfLines;
    private final Ladder ladder;

    public LadderView(int countOfPeople, int countOfLines) {
        this.countOfPeople = countOfPeople;
        this.countOfLines = countOfLines;
        this.ladder = new Ladder(countOfPeople, countOfLines);
    }

    private String checkPoints(ArrayList<Boolean> points, int col) {
        if (col % 2 == 0) return LADDER_VERT;

        if (points.get((col - 1) / 2)) return LADDER_HORI;

        return LADDER_EMP;
    }

    private void printEachPoint(ArrayList<Boolean> points) {
        for (int col = 0; col < 2 * countOfPeople - 1; col++) {
            System.out.print(checkPoints(points, col));
        }

        System.out.println();
    }

    public void printLadder() {
        for (int row = 0; row < countOfLines; row++) {
            ArrayList<Boolean> points = ladder.getLines().get(row).getPoints();

            printEachPoint(points);
        }
    }
}

