package service.domain;

import dto.LadderInputRawData;
import service.domain.Ladder;

public interface LadderGenerator {
    public Ladder buildLadder(LadderInputRawData ladderInputRawData);
}
