package laddergame.ladder;

import java.util.Random;

class LadderRow {
    private final Random rd = new Random();
    private final char[] ladderMap;

    public LadderRow(int participantsNum) {
        int length = participantsNum * 2 - 1;

        ladderMap = new char[length];
        for (int i=0; i<length; i=i+2)
            ladderMap[i] = '|';
        for (int i=1; i<length; i=i+2)
            ladderMap[i] = createRandomConnection();
    }

    private char createRandomConnection() {
        if (rd.nextBoolean())
            return '-';
        return ' ';
    }

    public void printRow() {
        System.out.println(ladderMap);
    }
}