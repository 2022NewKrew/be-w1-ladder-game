package DTO;

import domain.Ladder;
import domain.LadderLine;

import java.util.List;

public class OutputDTO {
    private final List<String> people;
    private final List<String> peopleSwapped;
    private final List<String> results;
    private final List<LadderLine> ladderLines;

    public OutputDTO(Ladder ladder) {
        this.people = ladder.getPeople();
        this.peopleSwapped = ladder.getPeopleSwapped();
        this.results = ladder.getResults();
        this.ladderLines = ladder.getLadderLines();
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getPeopleSwapped() {
        return peopleSwapped;
    }

    public List<String> getResults() {
        return results;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
