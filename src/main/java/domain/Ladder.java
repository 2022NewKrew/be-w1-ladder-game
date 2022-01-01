package domain;

import DTO.InputDTO;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<String> people;
    private final List<String> results;
    private final int heightOfLadder;
    private final List<LadderLine> ladderLines = new ArrayList<>();

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

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}