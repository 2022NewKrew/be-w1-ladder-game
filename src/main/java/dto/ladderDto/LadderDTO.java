package dto.ladderDto;

import domain.ladder.Ladder;
import domain.ladder.LadderFrameLine;

import java.util.Collections;
import java.util.List;

public class LadderDTO {
    private final List<LadderFrameLine> lines;

    private LadderDTO(Ladder ladder) {
        lines = Collections.unmodifiableList(ladder.getLines());
    }

    public static LadderDTO getLadderDTO(Ladder ladder) {
        return new LadderDTO(ladder);
    }

    public List<LadderFrameLine> getLines() {
        return lines;
    }
}
