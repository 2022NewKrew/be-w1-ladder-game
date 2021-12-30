package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Ladder 테스트")
class LadderTest {

    private static final int TEST_FRAME_LENGTH = 10;
    private static final int TEST_LADDER_HEIGHT = 10;

    @DisplayName("Ladder클래스 생성자 테스트")
    @Nested
    class ConstructorTest {
        private final Ladder testLadder = new Ladder(TEST_FRAME_LENGTH, TEST_LADDER_HEIGHT);

        @DisplayName("Ladder 높이가 올바른지 확인")
        @Test
        public void isLegalHeight() {
            assertThat(testLadder
                    .getLines()
                    .size())
                    .isEqualTo(TEST_LADDER_HEIGHT);
        }

        @DisplayName("Ladder 넓이가 올바른지 확인")
        @Test
        public void isLegalWidth() {
            assertThat(testLadder
                    .getLines()
                    .get(0)
                    .getFrames()
                    .size())
                    .isEqualTo(TEST_FRAME_LENGTH - 1);
        }
    }

}
