package dto;

public class LadderInputInfo {
    private final int numberOfParticipants;
    private final int heights;

    public LadderInputInfo(int numberOfParticipants, int heights) {
        this.numberOfParticipants = numberOfParticipants;
        this.heights = heights;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public int getHeights() {
        return heights;
    }
}
