package configuration;

public class LadderGameConfiguration {

    private final int numberOfMan;

    private final int maxHeightOfLadder;

    public LadderGameConfiguration(int numberOfMan, int maxHeightOfLadder) {
        this.numberOfMan = numberOfMan;
        this.maxHeightOfLadder = maxHeightOfLadder;
    }

    public int getNumberOfMan() {
        return numberOfMan;
    }

    public int getMaxHeightOfLadder() {
        return maxHeightOfLadder;
    }
}
