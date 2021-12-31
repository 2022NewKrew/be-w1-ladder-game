package domain;

import common.value.LadderHeight;
import common.value.PlayerCount;

public interface LadderGenerator {
    Ladder generate(PlayerCount playerCount, LadderHeight ladderHeight);
}
