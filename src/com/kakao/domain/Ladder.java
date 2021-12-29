package com.kakao.domain;

import java.util.*;

public class Ladder {

    private final ArrayList<String> participants;
    private final int height;
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(ArrayList<String> participants, int height) {
        this.participants = participants;
        this.height = height;
        setLadder();
    }

    private void setLadder() {
        for (int i = 0; i < height; i++) {
            Line line = new Line(participants);
            ladder.add(line);
        }
    }

    public void printLadder() {
        System.out.println(String.join(" ", participants));
        for (Line line : ladder) {
            System.out.println(line.getLine());
        }
    }
}
