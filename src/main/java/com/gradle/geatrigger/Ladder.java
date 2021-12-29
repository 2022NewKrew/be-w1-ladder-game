package com.gradle.geatrigger;

public class Ladder {
    final static int INTERVAL = 5;

    int[][] ladder;
    // width, height의 경우 이미 Ladder 인스턴스에 속해있어 ladder 생략
    int peopleCount, width, height;
    String[] names;

    StringBuilder sb;

    public Ladder(int peopleCount, int height, String namesString) {
        this.peopleCount = peopleCount;
        this.width = peopleCount - 1;
        this.height = height;
        this.ladder = new int[this.height][this.width];
        this.names = namesString.split(",");
        sb = new StringBuilder();
    }

    public void makeLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ladder[i][j] = (int) Math.round(Math.random());
            }
        }
    }

    public String toString() {
        sb.setLength(0);
        writeNames();
        writeLadder();
        return sb.toString();
    }

    private void writeLadder() {
        for (int i = 0; i < height; i++) {
            sb.append(" ".repeat(INTERVAL / 2));
            for (int j = 0; j < width; j++) {
                sb.append(makeVerticals());
                sb.append(makeHorizons(ladder[i][j] * INTERVAL));
            }
            sb.append(makeVerticals());
            sb.append("\n");
        }
    }

    private void writeNames() {
        for (String name : names) {
            sb.append(" ".repeat(INTERVAL / 2 - name.length() / 2));
            sb.append(name);
            sb.append(" ".repeat((INTERVAL - INTERVAL / 2) - (name.length() - name.length() / 2) + 1));
        }
        sb.append("\n");
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
