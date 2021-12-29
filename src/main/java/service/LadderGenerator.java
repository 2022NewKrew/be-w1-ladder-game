package service;

import dto.Ladder;
import dto.LadderInputInfo;

public interface LadderGenerator {
    public Ladder buildLadder(LadderInputInfo ladderInputInfo);
}
