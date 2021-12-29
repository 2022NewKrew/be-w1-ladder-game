package com.kakao.domain;

import java.util.*;

public class Ladder {

    private int participants;
    private int height;
    private int arraySize;
    private Random random = new Random();
    private ArrayList<String[]> ladder = new ArrayList<>();

    public Ladder(int participants, int height) {
        this.participants = participants;
        this.height = height;
        this.arraySize = 2*participants - 1;
        this.makeLadder();
    }

    private String selectLadder(int index) {
        if (index % 2 == 0) {
            return "|";
        }
        return random.nextBoolean() ? "-" : " ";
    }

    private void makeLine() {
        String[] line = new String[this.arraySize];
        for (int i = 0; i < this.arraySize; i++) {
            line[i] = this.selectLadder(i);
        }
        this.ladder.add(line);
    }

    private void makeLadder() {
        for (int i = 0; i < this.height; i++) {
            this.makeLine();
        }
    }

    public void printLadder() {
        for (String[] line : this.ladder) {
            String stringLine = String.join("", line);
            System.out.println(stringLine);
        }
    }
}
