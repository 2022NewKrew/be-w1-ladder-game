package dto;

import domain.ladder.Ladder;
import domain.ladder.LadderFrameLine;

import java.util.Collections;
import java.util.List;

public class LadderDTO {
    private final List<LadderFrameLine> lines;

    public LadderDTO(Ladder ladder){
        lines = Collections.unmodifiableList(ladder.getLines());
    }

    public List<LadderFrameLine> getLines() {
        return lines;
    }
}
