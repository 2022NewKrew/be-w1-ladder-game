package Ladder.DTO;

import Ladder.HorizBarLine;
import Ladder.NameLine;

public class outputNameDTO {
    private final NameLine line;

    public outputNameDTO(NameLine paramLine) {
        line = paramLine;
    }

    public NameLine getLine() {
        return line;
    }
}
