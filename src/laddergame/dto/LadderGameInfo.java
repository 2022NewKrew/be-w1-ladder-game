package laddergame.dto;

import java.util.List;

public class LadderGameInfo {
    private List<String> peopleNames;
    private Integer ladderHeight;

    public LadderGameInfo(List<String> peopleNames, Integer ladderHeight) {
        this.peopleNames = peopleNames;
        this.ladderHeight = ladderHeight;
    }

    public List<String> getPeopleNames() {
        return peopleNames;
    }

    public Integer getLadderHeight() {
        return ladderHeight;
    }
}
