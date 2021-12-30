package step_4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step_4.dto.LadderInfo;
import step_4.dto.NameAndHeightInfo;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderBuilderTest {
    @Test
    @DisplayName("입력된 사다리 정보에 따라 사다리가 정상적으로 생성되는지에 대한 테스트")
    void build() {
        // given
        final String[] names = {"mino", "andy", "jeff", "raon", "keith"};
        final int width = names.length - 1;
        final int height = 5;

        final LadderInfo ladderInfo = new NameAndHeightInfo(names, height);

        final LadderBuilder ladderBuilder = new LadderBuilder();

        // when
        final Ladder ladder = ladderBuilder.build(ladderInfo);

        // then
        assertEquals(width, ladder.getWidth());
        assertEquals(height, ladder.getHeight());
    }
}