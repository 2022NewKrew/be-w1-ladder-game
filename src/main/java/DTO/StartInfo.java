package DTO;

import java.util.List;

public class StartInfo {
    private final int numPeople;
    private final int maxHeight;
    private final List<String> namePeople;

    public StartInfo(int numPeople, List<String> namePeople, int maxHeight) {
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

    public List<String> getNamePeople() {
        return namePeople;
    }
}
