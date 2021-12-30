package ladder.domain;

public class LadderConfig {
    private final int nPeople;
    private final int maxHeight;
    private final String[] peopleNames;

    public LadderConfig(int nPeople, int maxHeight, String[] peopleNames) {
        this.nPeople = nPeople;
        this.maxHeight = maxHeight;
        this.peopleNames = peopleNames;
    }

    public int getNumPeople(){
        return this.nPeople;
    }
    public int getMaxHeight(){
        return this.maxHeight;
    }
    public String[] getPeopleNames(){
        return this.peopleNames;
    }

}
