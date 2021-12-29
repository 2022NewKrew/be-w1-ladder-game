package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    private final int numPeople;
    private final int height;
    private ArrayList<String> names;
    private ArrayList<String> ladder;
    private final Random random;
    private static final String[] pattern = {"- ", " "};

    public Ladder(String[] names, int height) {
        this.names = new ArrayList<String>(Arrays.asList(names));
        this.ladder = new ArrayList<String>();
        this.numPeople = names.length;
        this.height = height;
        random = new Random();
        makeNewLadder();
    }

    private void makeNewLadder() {
        for(int y = 0; y < height; y++) {
            ladder.add(makeNewLine(numPeople - 1));
        }
    }

    private String makeNewLine(int width) {
        StringBuilder ret = new StringBuilder();
        while(ret.length() < width) {
            ret.append(pattern[random.nextInt(2)]);
        }
        return ret.substring(0, width);
    }

    public void printLadder() {
        printNames();
        for(int y = 0; y < height; y++) {
            printLine(y);
        }
    }

    private void printNames() {
        for(int i = 0; i < numPeople; i++) {
            int frontSpace = (5 - names.get(i).length()) / 2;
            int backSpace = 5 - frontSpace - names.get(i).length() + 1;
            System.out.print(new StringBuilder(" ".repeat(frontSpace)) + names.get(i) + " ".repeat(backSpace));
        }
        System.out.println();
    }

    private void printLine(int y) {
        System.out.println(new StringBuilder("  |")
                                + Arrays.stream(ladder.get(y).split(""))
                                        .map(s->s.repeat(5))
                                        .collect(Collectors.joining("|"))
                                + "|");
    }
}
