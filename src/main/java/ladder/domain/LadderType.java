package ladder.domain;

import static ladder.domain.Ladder.typeSize;

public enum LadderType {
    BLANK(" ".repeat(typeSize)),
    BRIDGE("-".repeat(typeSize)),
    BAR("|");

    private final String ladderString;
    LadderType(String ladderString) {
        this.ladderString = ladderString;
    }
    @Override
    public String toString() {
        return ladderString;
    }
}
