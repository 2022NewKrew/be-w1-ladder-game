package com.kakao.domain;

import java.util.*;

public class Line {

    private final List<String> participants;
    private final List<Step> stepLine = new ArrayList<>();

    public Line(List<String> participants) {
        this.participants = participants;
        setStepLine();
    }

    public List<Step> getStepLine() { return stepLine; }

    private void setStepLine() {
        int stepCnt = participants.size()-1;
        for (int i = 0; i < stepCnt; i++) {
            stepLine.add(makeStep());
        }
    }

    private Step makeStep() {
        int lastIndex = stepLine.size()-1;
        if (stepLine.isEmpty() || !stepLine.get(lastIndex).isStep()) {
            return new Step(true);
        }
        return new Step(false);
    }

    public List<String> playGame(List<String> gameResult) {
        int stepCnt = stepLine.size();
        for (int i = 0; i < stepCnt; i++) {
            gameResult = swapResult(gameResult, i);
        }
        return gameResult;
    }

    private List<String> swapResult(List<String> gameResult, int stepIdx) {
        Step step = stepLine.get(stepIdx);
        if (step.isStep()) {
            String temp = gameResult.get(stepIdx);
            gameResult.set(stepIdx, gameResult.get(stepIdx+1));
            gameResult.set(stepIdx+1, temp);
        }
        return gameResult;
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
