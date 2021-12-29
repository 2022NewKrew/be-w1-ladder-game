package ladder;

import ladder.domain.Ladder;
import dto.LadderInputInfo;

public interface LadderBuilder {
    public Ladder createLadder(LadderInputInfo ladderInputInfo);
}
