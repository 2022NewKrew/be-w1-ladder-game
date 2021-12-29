import java.io.InputStream;
import java.util.Scanner;

public class LadderGame {
    private final int RANDOM_FLAG_THRESHOLD = 40;

    private int ladderWidth;
    private int ladderHeight;
    private boolean[][] ladderLineFlag;

    LadderGame() {
    }

    void startGame() {
        inputLadderInfo();
        setLadderLineFlag();
        printLadder();
    }

    void inputLadderInfo() {
        InputStream inputStream = System.in;
        Scanner scan = new Scanner(inputStream);

        System.out.println("참여할 사람은 몇 명인가요?");
        this.ladderWidth = scan.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.ladderHeight = scan.nextInt();
    }

    void setLadderLineFlag() {
        this.ladderLineFlag = new boolean[ladderWidth - 1][ladderHeight];
        for (int i = 0; i < ladderWidth - 1; i++)
            for (int j = 0; j < ladderHeight; j++)
                ladderLineFlag[i][j] = getRandomFlag();
    }

    boolean getRandomFlag() {
        double randomValue = (int) (Math.random() * 100);
        if (randomValue <= RANDOM_FLAG_THRESHOLD)
            return true;
        else
            return false;
    }

    void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < ladderWidth - 1; j++) {
                System.out.print("|");
                if (ladderLineFlag[j][i])
                    System.out.print("-");
                else
                    System.out.print(" ");
            }
            System.out.print("|\n");
        }
    }
}