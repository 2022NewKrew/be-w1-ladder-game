public class Ladder {
    private int numberOfParticipants;
    private int ladderHeight;
    private boolean[][] bridge;

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    public boolean[][] getBridge() {
        return bridge;
    }

    public void setBridge(boolean[][] bridge) {
        this.bridge = bridge;
    }

    public String getLadderString() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            for (int i = 0; i < this.ladderHeight; i++) {
                for (int j = 0; j < this.numberOfParticipants * 2 - 1; j++) {
                    stringBuilder.append(getBridgeChar(i, j));
                }
                stringBuilder.append("\n");
            }
        } catch (Exception e) {
            System.err.println("error message : " + e.getMessage());
            e.printStackTrace();
            throw new Exception(e);
        }

        return stringBuilder.toString();
    }

    private String getBridgeChar(int row, int col) {
        if (col % 2 == 0) {
            return "|";
        } else if (this.bridge[row][col / 2]) {
            return "-";
        } else {
            return " ";
        }
    }
}
