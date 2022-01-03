package domain;

import dto.NameAndResultInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import dto.LadderInfo;
import dto.NameAndHeightInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderBuilderTest {
    @Test
    @DisplayName("입력된 사다리 정보에 따라 사다리가 정상적으로 생성되는지에 대한 테스트")
    void build() {
        // given
        final String[] names = {"mino", "andy", "jeff", "raon", "keith"};
        final String[] results = {"5000", "10000", "꽝", "100000", "1000"};
        final int width = names.length - 1;
        final int height = 5;

        final LadderInfo ladderInfo = new NameAndResultInfo(names, results, height);

        final LadderBuilder ladderBuilder = new LadderBuilder();

        // when
        final Ladder ladder = ladderBuilder.build(ladderInfo);

        // then
        assertEquals(width, ladder.getWidth());
        assertEquals(height, ladder.getHeight());
    }
}