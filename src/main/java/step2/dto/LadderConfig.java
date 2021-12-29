package step2.dto;

public class LadderConfig {
    private int numOfPeople;
    private int height;

    protected LadderConfig() {
    }

    public static LadderConfig of(int numOfPeople, int height) {
        final LadderConfig ladderConfig = new LadderConfig();
        ladderConfig.height = height;
        ladderConfig.numOfPeople = numOfPeople;

        return ladderConfig;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public int getHeight() {
        return height;
    }
}
