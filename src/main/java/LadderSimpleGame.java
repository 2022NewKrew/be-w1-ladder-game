import java.util.Random;

public class LadderSimpleGame extends LadderGame {
    private boolean[][] bridge;
    private final Random randomInstance = new Random();
    private static final String PARTICIPANT_LINE = "|";
    private static final String MOVE_LINE = "-----";
    private static final String EMPTY_LINE = " ";

    public void createBridge() {
        int row = this.getLadderHeight();
        int col = this.getNumberOfParticipants() - 1;
        this.bridge = createLadderMap(row, col);
    }

    public String getLadderString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (boolean[] floor : this.bridge) {
            stringBuilder.append(getFloorString(floor));
        }

        return stringBuilder.toString();
    }

    private boolean[] createFloorMap(int col) {
        boolean[] map = new boolean[col];
        for (int j = 0; j < col; j++) {
            // 연속된 다리가 나올수 없음.
            map[j] = (j <= 0 || !map[j - 1]) && trueAndFalseGenerator();
        }

        return map;
    }

    private boolean[][] createLadderMap(int row, int col) {

        boolean[][] ladderMap = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            ladderMap[i] = createFloorMap(col);
        }

        return ladderMap;
    }

    private boolean trueAndFalseGenerator() {
        return randomInstance.nextBoolean();
    }

    private String getFloorString(boolean[] floor) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int col = 0; col < this.getNumberOfParticipants() * 2 - 1; col++) {
            stringBuilder.append(getBridgeChar(col, floor));
        }

        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private String getBridgeChar(int col, boolean[] floor) {
        if (col % 2 == 0) {
            return PARTICIPANT_LINE;
        } else if (floor[col / 2]) {
            return MOVE_LINE;
        }

        return EMPTY_LINE;

    }
}
