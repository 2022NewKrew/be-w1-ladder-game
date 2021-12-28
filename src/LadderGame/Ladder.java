package LadderGame;

import java.util.Random;

public class Ladder {
    public int ladderWidth, ladderHeight;
    public boolean[][] hasRightLadder;

    public Ladder(int ladderWidth, int ladderHeight) {
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
        this.hasRightLadder = makeRightLadder();
    }

    public boolean[][] makeRightLadder() {
        Random randomInstance = new Random();
        boolean[][] hasRightLadder = new boolean[ladderHeight][ladderWidth];

        for (int ladderRow = 0; ladderRow < ladderHeight; ladderRow++) {
            for (int ladderCol = 0; ladderCol < ladderWidth - 1; ladderCol++) {
                hasRightLadder[ladderRow][ladderCol] = randomInstance.nextBoolean();
            }
        }
        return hasRightLadder;
    }

    public void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < ladderWidth; j++) {
                System.out.print("|");
                if (hasRightLadder[i][j]) System.out.print("-");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
