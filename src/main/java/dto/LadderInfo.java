package dto;

public class LadderInfo {
    private final int numberOfParticipants;
    private final int heights;

    public LadderInfo(int numberOfParticipants, int heights) {
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
