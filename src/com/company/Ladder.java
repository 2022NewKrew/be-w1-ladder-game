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
                System.out.println("|");
                if(ladder[y][x])
                    System.out.println("-");
                else
                    System.out.println(" ");
            }
            System.out.println("|");
        }
    }
}
