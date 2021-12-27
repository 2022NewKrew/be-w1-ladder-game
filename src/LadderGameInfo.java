import java.util.Random;

public class LadderGameInfo {
    private int playerCnt;
    private int ladderHeight;
    private int ladderWidth;
    private static char[][] ladder;

    public LadderGameInfo(int playerCnt, int ladderHeight) {
        this.playerCnt = playerCnt;
        this.ladderHeight = ladderHeight;
        this.ladderWidth = (playerCnt * 2) - 1;
    }

    public void makeLadder() {
        Random random = new Random();
        ladder = new char[ladderHeight][ladderWidth];

        for (int i = 0; i < ladderHeight; ++i) {
            for (int j = 0; j < ladderWidth; ++j) {
                ladder[i][j] = (j % 2 == 0) ? '|' : (random.nextBoolean() ? ' ' : '-');
            }
        }
    }

    public void drawLadder() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ladderHeight; ++i) {
            for (int j = 0; j < ladderWidth; ++j) {
                sb.append(ladder[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
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
