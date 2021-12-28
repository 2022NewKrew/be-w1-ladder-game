package service;

import dto.Ladder;

public interface LadderGenerator {
    public Ladder buildLadder(int heights, int numberOfParticipants);
}
