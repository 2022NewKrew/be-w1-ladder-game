package DTO;

import domain.Ladder;
import domain.LadderLine;

import java.util.List;

public class OutputDTO {
    private Ladder ladder;
    private List<String> people;
    private List<String> results;
    private int heightOfLadder;
    private List<LadderLine> ladderLines;

    public OutputDTO(Ladder ladder) {
        this.ladder = ladder;
        this.people = ladder.getPeople();
        this.results = ladder.getResults();
        this.heightOfLadder = ladder.getHeightOfLadder();
        this.ladderLines = ladder.getLadderLines();
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
