package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private int numPeople;
    private int height;
    private boolean[][] ladder;
    public Ladder(int numPeople, int height) {
        this.numPeople = numPeople;
        this.height = height;
        makeNewLadder();
    }

    private void makeNewLadder() {
        Random random = new Random();
        ladder = new boolean[height][numPeople];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < numPeople; x++) {
                if(random.nextBoolean()) {
                    ladder[y][x] = true;
                    x++;
                }
            }
        }
    }

    public void printLadder() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < numPeople; x++) {
                System.out.print("|");
                if(ladder[y][x])
                    System.out.print("-");
                else
                    System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
