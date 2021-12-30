import java.util.ArrayList;

public class LadderGameInfo {
    private ArrayList<String> peopleNames;
    private Integer ladderHeight;

    public LadderGameInfo(ArrayList<String> peopleNames, Integer ladderHeight) {
        this.peopleNames = peopleNames;
        this.ladderHeight = ladderHeight;
    }

    public ArrayList<String> getPeopleNames() {
        return peopleNames;
    }

    public Integer getLadderHeight() {
        return ladderHeight;
    }
}
