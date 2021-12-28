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
            ladder[i][0] = '|';
            int bridge = rand.nextInt(width/2);
            for (int j=1; j<width; j++) {
                if (bridge == j/2) {
                    ladder[i][j++] = '-';
                } else {
                    ladder[i][j++] = ' ';
                }
                ladder[i][j] = '|';
            }
        }
    }

    void printLadder(){
        StringBuilder output = new StringBuilder();

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                output.append(ladder[i][j]);
            }
            output.append("\n");
        }
        System.out.println(output);
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
