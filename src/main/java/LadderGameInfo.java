import java.util.Random;

public class LadderGameInfo {
    private static final Random random = new Random();

    private int playerCnt;
    private int ladderHeight;
    private int ladderWidth;
    private char[][] ladder;

    public LadderGameInfo(int playerCnt, int ladderHeight) {
        this.playerCnt = playerCnt;
        this.ladderHeight = ladderHeight;
        this.ladderWidth = (playerCnt * 2) - 1;
    }

    public void makeLadder() {
        ladder = new char[ladderHeight][ladderWidth];

        for (int i = 0; i < ladderHeight; ++i) {
            ladder[i] = makeLadderLine();
        }
    }

    private char[] makeLadderLine() {
        char[] ladderLine = new char[ladderWidth];

        for (int i = 0; i < ladderWidth; ++i) {
            ladderLine[i] = getLadderLine(i);
        }

        return ladderLine;
    }

    private char getLadderLine(int i) {
        if (i % 2 == 0) {
            return '|';
        }

        if (random.nextBoolean()) {
            return '-';
        }

        return ' ';
    }

    public void drawLadder() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ladderHeight; ++i) {
            sb.append(drawLadderLine(i)).append("\n");
        }

        System.out.println(sb);
    }

    private String drawLadderLine(int i) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < ladderWidth; ++j) {
            sb.append(ladder[i][j]);
        }

        return sb.toString();
    }

    public int getPlayerCnt() {
        return playerCnt;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }
}
