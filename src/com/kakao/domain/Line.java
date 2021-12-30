package com.kakao.domain;

import java.util.*;

class Line {

    private final List<String> participants;
    private final List<Step> stepLine = new ArrayList<>();

    Line(List<String> participants) {
        this.participants = participants;
        setStepLine();
    }

    List<Step> getStepLine() {
        return stepLine;
    }

    private void setStepLine() {
        int stepCnt = participants.size()-1;
        for (int i = 0; i < stepCnt; i++) {
            stepLine.add(makeStep());
        }
    }

    Step makeStep() {
        int lastIndex = stepLine.size()-1;
        if (stepLine.isEmpty() || !stepLine.get(lastIndex).isStep()) {
            return new Step(true);
        }
        return new Step(false);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("|");
        for (Step step : stepLine) {
            line.append(step);
            line.append("|");
        }
        return line.toString();
    }
}
