package step2LadderGame.domain.ladder;

import step2LadderGame.domain.ladderConfig.LadderConfig;

public interface LadderGenerator {
    Ladder generate(LadderConfig ladderConfig);
}
