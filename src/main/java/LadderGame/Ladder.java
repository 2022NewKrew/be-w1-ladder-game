package LadderGame;

import java.util.Random;

public class Ladder {
    private int height;
    private int width;
    private char[][] ladder;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        this.ladder = new char[height][width];
    }

    void makeLadder() {
        Random rand = new Random();

        for (int i=0; i<height; i++) {
            makeRow(i);
            ladder[i][0] = '|';
            int bridge = rand.nextInt(width/2);
        }
    }

    void makeRow(int i) {
        Random rand = new Random();
        int bridge = rand.nextInt(width/2);

        ladder[i][0] = '|';
        for (int j=1; j<width; j++) {
            ladder[i][j] = makeBridge(bridge, j++);
            ladder[i][j] = '|';
        }
    }

    char makeBridge(int bridge, int j) {
        if (bridge == j/2) {
            return '-';
        }
        return ' ';
    }

    void printLadder(){
        StringBuilder output = new StringBuilder();

        for (int i=0; i<height; i++) {
            setLadderRow(output, i);
            output.append("\n");
        }
        System.out.println(output);
    }

    void setLadderRow(StringBuilder output, int i) {
        for (int j=0; j<width; j++) {
            output.append(ladder[i][j]);
        }
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
