public class StartInfo {
    private final int numPeople;
    private final int maxHeight;

    public StartInfo(int numPeople, int maxHeight) {
        this.numPeople = numPeople;
        this.maxHeight = maxHeight;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
