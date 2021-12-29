package com.kakao.step3.view;

import com.kakao.step3.domain.ManipulateInfos;
import com.kakao.step3.domain.Validator;
import com.kakao.step3.model.Ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderView {
    private final int countOfPeople, countOfLines;
    private final String[] names;
    private final Ladder ladder;

    public LadderView(String[] names, int countOfLines) {
        this.names = names;
        this.countOfPeople = names.length;
        this.countOfLines = countOfLines;
        this.ladder = new Ladder(countOfPeople, countOfLines);
    }

    private void printOneLine(List<Boolean> points) {
        for (int i = -1; i < 2 * countOfPeople - 1; i++) {
            System.out.print(Validator.checkEachPoints(points, i));
        }

        System.out.println();
    }

    public void printLadder() {
        System.out.println("   " + ManipulateInfos.makeNameLine(names));

        for (int i = 0; i < countOfLines; i++) {
            List<Boolean> points = ladder.getLines().get(i).getPoints();
            printOneLine(points);
        }
    }
}

