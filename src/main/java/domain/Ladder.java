package domain;

import DTO.InputDTO;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<String> people;
    private List<String> results;
    private int heightOfLadder;

    private List<LadderLine> ladderLines = new ArrayList<LadderLine>();

    public Ladder(InputDTO inputDTO) {
        people = inputDTO.getPeople();
        results = inputDTO.getResults();
        heightOfLadder = inputDTO.getHeightOfLadder();
        buildLadder();
    }

    private void buildLadder() {
        for(int i = 0 ; i < heightOfLadder ; i++) {
            LadderLine line = new LadderLine(people.size());
            ladderLines.add(line);
        }
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getResults() {
        return results;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}