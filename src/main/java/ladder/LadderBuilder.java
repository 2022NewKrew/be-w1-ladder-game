package ladder;

import dto.LadderInputInfo;
import exception.LadderInfoMismatchException;

public interface LadderBuilder {
    public Ladder createLadder(LadderInputInfo ladderInputInfo) throws LadderInfoMismatchException;
}
