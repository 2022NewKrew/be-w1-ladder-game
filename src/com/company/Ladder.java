package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    private final int NUM_PEOPLE;
    private final int HEIGHT;
    private List<String> names;
    private List<String> ladderInfo;
    private List<String> ladderView;
    private final Random random;
    private static final String[] PATTERN = {"- ", " "};

    public Ladder(String[] names, int height) {
        this.names = Arrays.stream(names)
                            .map(s->s.substring(0, Math.min(s.length(), 5)))
                            .collect(Collectors.toList());
        this.ladderInfo = new ArrayList<String>();
        this.ladderView = new ArrayList<String>();
        this.NUM_PEOPLE = names.length;
        this.HEIGHT = height;
        random = new Random();
        makeNewLadder();
    }

    private void makeNewLadder() {
        for(int y = 0; y < HEIGHT; y++) {
            String newLine = makeNewLine(NUM_PEOPLE - 1);
            ladderInfo.add(newLine);
            ladderView.add("  |"
                    + Arrays.stream(newLine.split(""))
                    .map(s->s.repeat(5))
                    .collect(Collectors.joining("|"))
                    + "|");
        }
    }

    private String makeNewLine(int width) {
        StringBuilder ret = new StringBuilder();
        while(ret.length() < width) {
            ret.append(PATTERN[random.nextInt(2)]);
        }
        return ret.substring(0, width);
    }

    public void printLadder() {
        printNames();
        for(int y = 0; y < HEIGHT; y++) {
            printLine(y);
        }
    }

    private void printNames() {
        for(int i = 0; i < NUM_PEOPLE; i++) {
            System.out.print(getPaddedName(names.get(i), 5) + " ");
        }
        System.out.println();
    }

    private String getPaddedName(String name, int size) {
        int frontSpace = (size - name.length()) / 2;
        int backSpace = size - frontSpace - name.length();
        return " ".repeat(frontSpace) + name + " ".repeat(backSpace);
    }

    private void printLine(int y) {
        System.out.println(ladderView.get(y));
    }
}

