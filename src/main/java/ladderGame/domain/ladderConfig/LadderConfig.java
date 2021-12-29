package ladderGame.domain.ladderConfig;

public class LadderConfig {
    private int numOfPeople;
    private int height;

    protected LadderConfig() {
    }

    protected LadderConfig(int numOfPeople, int height) {
        this.height = height;
        this.numOfPeople = numOfPeople;
    }

    public static LadderConfig of(int numOfPeople, int height) {
        return new LadderConfig(numOfPeople, height);
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public int getHeight() {
        return height;
    }
}
