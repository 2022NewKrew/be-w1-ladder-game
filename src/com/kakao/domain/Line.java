package com.kakao.domain;

import java.util.*;

public class Line {

    private final ArrayList<String> participants;
    private final List<Step> line = new ArrayList<>();

    public Line(ArrayList<String> participants) {
        this.participants = participants;
        setLine();
    }

    public String getLine() {
        StringBuilder line = new StringBuilder("|");
        for (Step step : this.line) {
            line.append(step.getStep());
            line.append("|");
        }
        return line.toString();
    }

    private void setLine() {
        int stepCnt = participants.size()-1;
        for (int i = 0; i < stepCnt; i++) {
            line.add(makeStep());
        }
    }

    private Step makeStep() {
        int lastIndex = line.size()-1;
        if (line.isEmpty() || !line.get(lastIndex).isStep()) {
            return new Step(true);
        }
        return new Step(false);
    }
}
