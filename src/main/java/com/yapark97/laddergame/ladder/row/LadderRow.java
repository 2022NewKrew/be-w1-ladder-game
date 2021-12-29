package com.yapark97.laddergame.ladder.row;

import com.yapark97.laddergame.ladder.LadderConst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow implements Row {
    private final Random rd = new Random();
    private final List<Boolean> connections;
    private final int participantsNum;
    //private final char[] ladderBlocks;

    public LadderRow(int participantsNum) {
        //int length = participantsNum * 2 - 1;

        //ladderBlocks = new char[length];
        this.participantsNum = participantsNum;
        connections = new ArrayList<>();
        initLadderBlockRow(participantsNum);
        //createLadderBlocks(length);
    }

    @Override
    public void print() {
        for (int i=0; i<participantsNum; i++) {
            printColumn(i);
        }
        System.out.print("\n");
    }

    private void initLadderBlockRow(int participantsNum) {
        for (int i=0; i<participantsNum-1; i++) {
            connections.add(createRandomConnection(i));
        }
    }

    private void printColumn(int index) {
        char left = (index == 0 || !connections.get(index-1)) ? LadderConst.BLANK : LadderConst.HORIZONTAL_LINE;
        char mid = LadderConst.VERTICAL_LINE;
        char right = (index == participantsNum-1 || !connections.get(index)) ? LadderConst.BLANK : LadderConst.HORIZONTAL_LINE;

        for (int i=0; i<(LadderConst.WIDTH-1)/2; i++) {
            System.out.print(left);
        }
        System.out.print(mid);
        for (int i=0; i<LadderConst.WIDTH/2; i++) {
            System.out.print(right);
        }
    }

    /*private void createLadderBlocks(int length) {
        for (int i=0; i<length; i=i+2) {
            ladderBlocks[i] = LadderBlock.VERTICAL_LINE;
        }
        for (int i=1; i<length; i=i+2) {
            ladderBlocks[i] = createRandomConnection(i);
        }
    }*/

    private boolean createRandomConnection(int index) {
        if (index > 0 && connections.get(index - 1)) {
            return false;
        }
        return rd.nextBoolean();
    }
}