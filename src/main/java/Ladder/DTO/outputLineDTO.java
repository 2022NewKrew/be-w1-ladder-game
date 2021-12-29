package Ladder.DTO;

import Ladder.HorizBarLine;

public class outputLineDTO {
    private final HorizBarLine line;

    public outputLineDTO(HorizBarLine paramLine) {
        line = paramLine;
    }

    public HorizBarLine getLine() {
        return line;
    }
}