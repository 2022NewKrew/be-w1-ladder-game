package ladder;

import dto.LadderInputInfo;

public interface LadderBuilder {
    public Ladder createLadder(LadderInputInfo ladderInputInfo);
}
