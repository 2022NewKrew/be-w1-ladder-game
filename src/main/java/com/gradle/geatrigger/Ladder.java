package com.gradle.geatrigger;

public class Ladder {
    static int[][] ladder;
    static int cnt, height;

    public Ladder(int cnt, int height) {
        this.cnt = cnt;
        this.height = height;
        this.ladder = new int[height][cnt];
    }

    public void makeLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < cnt - 1; j++) {
                ladder[i][j] = (int)Math.round(Math.random());
            }
            ladder[i][cnt - 1] = 0;
        }
    }

    public void drawLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < cnt; j++) {
                drawVertical();
                drawHorizon(ladder[i][j]);
            }
            System.out.println();
        }
    }

    private void drawHorizon(int cnt) {
        for (int i = 0; i < cnt; i++)
            System.out.print("-");
        if (cnt == 0)
            System.out.print(" ");
    }

    private void drawVertical() {
        System.out.print("|");
    }
}
