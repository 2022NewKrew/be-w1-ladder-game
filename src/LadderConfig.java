public class LadderConfig {
    private final int nPeople;
    private final int maxHeight;

    public LadderConfig(int nPeople, int maxHeight) {
        this.nPeople = nPeople;
        this.maxHeight = maxHeight;
    }

    public int getNumPeople(){
        return this.nPeople;
    }
    public int getMaxHeight(){
        return this.maxHeight;
    }

}
