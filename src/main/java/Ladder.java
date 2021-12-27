import java.util.Random;

public class Ladder {
    private final int participantsNum;
    private final int maxHeight;

    private final boolean[][] ladderMap;

    public Ladder(int participantsNum, int maxHeight) {
        this.participantsNum = participantsNum;
        this.maxHeight = maxHeight;

        ladderMap = new boolean[maxHeight][participantsNum-1];
        Random rd = new Random();
        for (int i=0; i<maxHeight; i++)
            for (int j=0; j<participantsNum-1; j++)
                ladderMap[i][j] = rd.nextBoolean();
    }

    public void printLadder() {
        for (int i=0; i<maxHeight; i++) {
            for (int j = 0; j<participantsNum-1; j++) {
                System.out.print("|");
                if (ladderMap[i][j]) System.out.print("-");
                else System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
