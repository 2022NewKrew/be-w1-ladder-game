package com.yapark97.laddergame.ladder;

import java.util.Random;

class LadderRow {
    private final Random rd = new Random();
    private final char[] ladderBlocks;

    public LadderRow(int participantsNum) {
        int length = participantsNum * 2 - 1;

        ladderBlocks = new char[length];
        createLadderBlocks(length);
    }

    private void createLadderBlocks(int length) {
        for (int i=0; i<length; i=i+2) {
            ladderBlocks[i] = LadderBlock.VERTICAL_LINE;
        }
        for (int i=1; i<length; i=i+2) {
            ladderBlocks[i] = createRandomConnection();
        }
    }

    private char createRandomConnection() {
        if (rd.nextBoolean()) {
            return LadderBlock.HORIZONTAL_LINE;
        }
        return LadderBlock.BLANK;
    }

    public void printRow() {
        System.out.println(ladderBlocks);
    }
}