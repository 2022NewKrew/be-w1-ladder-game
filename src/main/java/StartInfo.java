public class StartInfo {
    private final int numPeople;
    private final int maxHeight;
    private final String[] namePeople;

    public StartInfo(int numPeople, String[] namePeople, int maxHeight) {
        this.numPeople = numPeople;
        this.namePeople = namePeople;
        this.maxHeight = maxHeight;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public String[] getNamePeople() {
        return namePeople;
    }
}
