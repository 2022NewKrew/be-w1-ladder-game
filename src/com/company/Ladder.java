package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private int numPeople;
    private int height;
    private String[] ladder;
    private Random random;
    private static String[] pattern = {"- ", " "};
    public Ladder(int numPeople, int height) {
        this.numPeople = numPeople;
        this.height = height;
        random = new Random();
        makeNewLadder();
    }

    private void makeNewLadder() {
        ladder = new String[height];
        for(int y = 0; y < height; y++)
            ladder[y] = makeNewLine(numPeople-1);
    }

    private String makeNewLine(int width) {
        String ret = "";
        while(ret.length() < width)
            ret += pattern[random.nextInt(2)];
        return ret.substring(0, width);
    }

    public void printLadder() {
        for(int y = 0; y < height; y++)
            printLine(y);
    }
    public void printLine(int y) {
        System.out.println("|" + String.join("|", ladder[y].split("")) + "|");
    }
}
