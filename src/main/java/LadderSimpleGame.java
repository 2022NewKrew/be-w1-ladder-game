import java.util.Arrays;

public class LadderSimpleGame extends LadderGame {
    private boolean[][] bridge;
    private final LadderGameService ladderGameService;

    public LadderSimpleGame(LadderGameService ladderGameService) {
        this.ladderGameService = ladderGameService;
    }

    public void createBridge() {
        int row = this.getLadderHeight();
        int col = this.getNumberOfParticipants() - 1;
        this.bridge = ladderGameService.createLadderMap(row, col);
    }

    public String getLadderString() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        for (boolean[] floor : this.bridge) {
            stringBuilder.append(getFloorString(floor));
        }

        return stringBuilder.toString();
    }

    private String getFloorString(boolean[] floor) {

        System.out.println(Arrays.toString(floor));
        StringBuilder stringBuilder = new StringBuilder();

        for (int col = 0; col < this.getNumberOfParticipants() * 2 - 1; col++) {
            stringBuilder.append(getBridgeChar(col, floor));
        }

        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private String getBridgeChar(int col, boolean[] floor) {
        if (col % 2 == 0) {
            return "|";
        } else if (floor[col / 2]) {
            return "-";
        }

        return " ";

    }
}
