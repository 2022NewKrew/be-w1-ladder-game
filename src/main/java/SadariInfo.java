public class SadariInfo {

    private final int numberOfPeople;
    private final int numberOfLadder;

    public SadariInfo(int numberOfPeople, int numberOfLadder) {
        this.numberOfPeople = numberOfPeople;
        this.numberOfLadder = numberOfLadder;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public int getNumberOfColumn() {
        return getNumberOfPeople() * 2 - 1;
    }

    public int getNumberOfRow() {
        return numberOfLadder;
    }
}
