package DTO;

import java.util.List;

public class StartInfo {
    private final int numPeople;
    private final List<String> namePeople;
    private final List<String> resultString;
    private final int maxHeight;

    public StartInfo(int numPeople, List<String> namePeople, List<String> resultString, int maxHeight) {
        this.numPeople = numPeople;
        this.namePeople = namePeople;
        this.resultString = resultString;
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

    public List<String> getResultString() {
        return resultString;
    }
}
