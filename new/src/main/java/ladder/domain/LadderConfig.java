package ladder.domain;

public class LadderConfig {
    private final int nPeople;
    private final int maxHeight;
    private final String[] peopleNames;
    private final String[] outputs;

    public LadderConfig(int nPeople, int maxHeight, String[] peopleNames,  String[] outputs) {
        this.nPeople = nPeople;
        this.maxHeight = maxHeight;
        this.peopleNames = peopleNames;
        this.outputs = outputs;
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
    public String[] getOutputs() {return this.outputs;}

}
