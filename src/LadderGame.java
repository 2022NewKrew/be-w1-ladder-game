import java.io.InputStream;
import java.util.Scanner;

public class LadderGame {
    private final String DEFAULT_LADDER_LINE = "|";
    private final String RANDOM_LADDER_LINE = "-";
    private final String NO_LADDER_LINE = " ";

    private int peopleCount;
    private int ladderHeight;
    private Ladder ladder;

    LadderGame() {
    }

    void startGame() {
        inputLadderInfo();
        makeLadder();
        printLadder();
    }

    private void inputLadderInfo() {
        InputStream inputStream = System.in;
        Scanner scan = new Scanner(inputStream);

        System.out.println("참여할 사람은 몇 명인가요?");
        peopleCount = scan.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scan.nextInt();
    }

    private void makeLadder() {
        int ladderWidth = peopleCount - 1;
        this.ladder = new Ladder(ladderWidth, ladderHeight);
    }

    private void printLadder() {
        int ladderHeight = ladder.getHeight();
        for(int i = 0; i < ladderHeight; i++)
            System.out.println(getLadderLine(i));
    }

    private StringBuilder getLadderLine(int row) {
        StringBuilder ladderLine = new StringBuilder();
        ladderLine.append(DEFAULT_LADDER_LINE);

        int ladderWidth = ladder.getWidth();
        for(int i = 0; i < ladderWidth; i++) {
            ladderLine.append(getRandomLadderLine(row, i));
            ladderLine.append(DEFAULT_LADDER_LINE);
        }

        return ladderLine;
    }

    private String getRandomLadderLine(int row, int col) {
        Boolean lineFlag = ladder.getLineFlag(row, col);
        if(lineFlag)
            return RANDOM_LADDER_LINE;

        return NO_LADDER_LINE;
    }
}