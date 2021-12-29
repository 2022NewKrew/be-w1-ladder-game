package LadderGame;

import java.util.Random;

public class Ladder {
    private int height;
    private int width;
    private char[][] ladder;
    private int bridgeWidth;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width*2 - 1;
    }

    void makeLadder() {
        ladder = new char[height][width];
        for (int i=0; i<height; i++) {
            makeRow(i);
            ladder[i][0] = '|';
        }
    }

    private void makeRow(int i) {
        ladder[i][0] = '|';
        for (int j=1; j<width; j++) {
            ladder[i][j] = makeBridge(i, j++);
            ladder[i][j] = '|';
        }
    }

    private char makeBridge(int i, int j) {
        Random rand = new Random();
        if (j > 1 && ladder[i][j-2] == '-') {
            return ' ';
        }
        if (rand.nextBoolean()) {
            return '-';
        }
        return ' ';
    }

    void printLadder(int bridgeWidth){
        this.bridgeWidth = bridgeWidth;
        StringBuilder output = new StringBuilder();

        for (int i=0; i<height; i++) {
            setLadderRow(output, i);
            output.append("\n");
        }
        System.out.println(output);
    }

    private void setLadderRow(StringBuilder output, int i) {
        for (int j=0; j<width; j++) {
            output.append(getExtendBridge(ladder[i][j]));
        }
    }

    private String getExtendBridge(char r) {
        if (r == ' ') {
            return " ".repeat(bridgeWidth);
        }

        if (r == '-') {
            return "-".repeat(bridgeWidth);
        }

        return "|";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getLadder() {
        return ladder;
    }

    public void setLadder(char[][] ladder) {
        this.ladder = ladder;
    }
}
