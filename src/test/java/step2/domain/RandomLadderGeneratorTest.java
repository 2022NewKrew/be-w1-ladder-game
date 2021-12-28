package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.LadderConfig;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderGeneratorTest {

    @Test
    @DisplayName("원하는 크기의 사다리가 정상적으로 생성되는 테스트")
    void generate() {
        // given
        final int numOfPeople = 5;
        final int height = 10;

        final LadderConfig ladderConfig = LadderConfig.of(numOfPeople, height);
        final LadderGenerator ladderGenerator = new RandomLadderGenerator();

        final int width = numOfPeople * 2 - 1;

        // when
        Ladder ladder = ladderGenerator.generate(ladderConfig);

        // then
        assertEquals(ladder.getHeight(), height);
        assertEquals(ladder.getWidth(), width);
    }

}