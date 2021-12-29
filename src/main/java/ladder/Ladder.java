package ladder;

public class Ladder {

    private final String[] participants;
    private final int height;
    private final boolean[][] bridges;

    public Ladder(String[] participants, int height, boolean[][] bridges) {
        this.participants = participants;
        this.height = height;
        this.bridges = bridges;
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getHeight() {
        return height;
    }

    public boolean isConnected(int bridgeWidth, int bridgeHeight) {
        return bridges[bridgeHeight][bridgeWidth];
    }
}
