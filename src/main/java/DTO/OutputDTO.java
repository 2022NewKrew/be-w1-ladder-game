package DTO;

import domain.Ladder;
import domain.LadderLine;

import java.util.HashMap;
import java.util.List;

public class OutputDTO {
    private final List<String> people;
    private final HashMap<String, String> matchedResult;
    private final List<String> results;
    private final List<LadderLine> ladderLines;

    public OutputDTO(Ladder ladder) {
        this.people = ladder.getPeople();
        this.matchedResult = ladder.getMatchedResult();
        this.results = ladder.getResults();
        this.ladderLines = ladder.getLadderLines();
    }

    public List<String> getPeople() {
        return people;
    }

    public HashMap<String, String> getMatchedResult() {
        return matchedResult;
    }

    public List<String> getResults() {
        return results;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
