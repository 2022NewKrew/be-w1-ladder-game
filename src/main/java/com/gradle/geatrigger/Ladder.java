package com.gradle.geatrigger;

public class Ladder {
    int[][] ladder;
    // width, height의 경우 이미 Ladder 인스턴스에 속해있어 ladder 생략
    int peopleCount, width, height;

    public Ladder(int peopleCount, int height) {
        this.peopleCount = peopleCount;
        this.width = peopleCount - 1;
        this.height = height;
        this.ladder = new int[this.height][this.width];
    }

    public void makeLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ladder[i][j] = (int) Math.round(Math.random());
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(makeVerticals());
                sb.append(makeHorizons(ladder[i][j]));
            }
            sb.append(makeVerticals());
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
