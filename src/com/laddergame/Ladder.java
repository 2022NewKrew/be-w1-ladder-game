package com.laddergame;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    //상수 및 클래스 변수

    //인스턴스 변수
    private final int peopleSize;
    private final int ladderSize;
    private ArrayList<ArrayList<Boolean>> ladder;

    //생성자
    public Ladder(int peopleSize, int ladderSize) {
        this.peopleSize = peopleSize;
        this.ladderSize = ladderSize;
        createLadder();
    }

    //메서드
    private ArrayList<Boolean> createLadderRow() {
        Random rand = new Random();
        ArrayList<Boolean> ladderRow = new ArrayList<>(peopleSize-1);
        for(int i = 0; i < peopleSize-1; i++) {
            ladderRow.add(rand.nextBoolean());
        }
        return ladderRow;
    }

    private void createLadder() {
        Random rand = new Random();
        ladder = new ArrayList<>();
        for(int i = 0; i < ladderSize; i++) {
            ladder.add(createLadderRow());
        }
    }

    private StringBuilder toStringRow(ArrayList<Boolean> row) {
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        for (Boolean e : row) {
            sb.append(e ? " |" : "-|");
        }
        sb.append('\n');
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Boolean> row : ladder) {
            sb.append(toStringRow(row));
        }
        return sb.toString();
    }
}
