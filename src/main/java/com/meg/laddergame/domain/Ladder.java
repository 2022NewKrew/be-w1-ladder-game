package com.meg.laddergame.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final int countOfPerson;
    private final int height;
    private final List<Line> lines;
    private final List<Integer> answers;

    Ladder(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = height;
        this.lines = new ArrayList<>(height);
        this.answers = new ArrayList<>(countOfPerson);
        setLadder();
        setAnswers();
    }

    private void setLadder() {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    private void setAnswers() {
        for (int i = 0; i < countOfPerson; i++) {
            answers.add(i);
        }
        for (Line line : lines) {
            setAnswersOfLine(line);
        }
    }

    private void setAnswersOfLine(Line line) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            swapAnswer(line.getpoints().get(i), i, i + 1);
        }
    }

    private void swapAnswer(Boolean isBridge, int a, int b) {
        if (isBridge) {
            Collections.swap(answers, a, b);
        }
    }

    public List<Integer> getAnswers() {
        return answers;
    }

}
