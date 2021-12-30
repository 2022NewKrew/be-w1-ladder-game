package domain;

import common.value.LadderHeight;
import common.value.PlayerCount;
import domain.value.Ladder;

public interface LadderGenerator {
    Ladder generate(LadderHeight ladderHeight, PlayerCount playerCount);
}
