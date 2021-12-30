package step2LadderGame.domain.ladderConfig;

public class LadderConfig {
    private final int numOfParticipants;
    private final int height;

    public LadderConfig(int numOfParticipants, int height) {
        this.height = height;
        this.numOfParticipants = numOfParticipants;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public int getHeight() {
        return height;
    }
}
