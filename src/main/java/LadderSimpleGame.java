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

        for (int i = 0; i < this.getLadderHeight(); i++) {
            for (int j = 0; j < this.getNumberOfParticipants() * 2 - 1; j++) {
                stringBuilder.append(getBridgeChar(i, j));
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private String getBridgeChar(int row, int col) {
        if (col % 2 == 0) {
            return "|";
        } else if (this.bridge[row][col / 2]) {
            return "-";
        }

        return " ";

    }
}
