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
                ladder[i][j] = (int) Math.round(Math.random());
            }
            ladder[i][cnt - 1] = 0;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < cnt; j++) {
                sb.append(makeVerticals());
                sb.append(makeHorizons(ladder[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String makeHorizons(int cnt) {
        if (cnt == 0)
            return " ";
        return "-".repeat(cnt);
    }

    private String makeVerticals() {
        return "|";
    }
}
