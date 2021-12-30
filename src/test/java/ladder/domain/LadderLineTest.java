package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {

    LadderLine ladderLine;

    static final int[] testWidths = {5, 10, 11, 17, 21, 30, 100};

    @BeforeEach
    void initTest() {
        ladderLine = new LadderLine();
    }

    @Test
    @DisplayName("연결 전략이 항상 true 일 때, 라인 연결 테스트")
    void makeLineTest2() {
        for (int width : testWidths) {
            ladderLine.makeLine(() -> true, width);
            assertThat(ladderLine.getLine().stream().filter(Boolean::booleanValue).count())
                .isEqualTo(width / 2 + (width % 2));
        }
    }
}
