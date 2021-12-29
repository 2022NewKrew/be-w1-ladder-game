package step2.domain;

import step2.dto.LadderConfig;

public interface LadderGenerator {
    Ladder generate(LadderConfig ladderConfig);
}
