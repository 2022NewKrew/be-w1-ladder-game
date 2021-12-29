package ladderGame.domain.ladder;

import ladderGame.domain.ladderConfig.LadderConfig;

public interface LadderGenerator {
    Ladder generate(LadderConfig ladderConfig);
}
