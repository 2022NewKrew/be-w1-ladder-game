package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Ladder 테스트")
class LadderTest {
    @DisplayName("Ladder클래스 생성자 테스트")
    @Nested
    class ConstructorTest {
        @DisplayName("Ladder 높이가 올바른지 확인")
        @Test
        public void isLegalHeight() {
            //Give
            final int TEST_LADDER_HEIGHT = 10;
            final int TEST_FRAME_LENGTH = 10;
            //When
            final Ladder testLadder = new Ladder(TEST_FRAME_LENGTH, TEST_LADDER_HEIGHT);
            //Then
            assertThat(testLadder
                    .getLines()
                    .size())
                    .isEqualTo(TEST_LADDER_HEIGHT);
        }

        @DisplayName("Ladder 넓이가 올바른지 확인")
        @Test
        public void isLegalWidth() {
            //Give
            final int TEST_LADDER_HEIGHT = 10;
            final int TEST_FRAME_LENGTH = 10;
            //When
            final Ladder testLadder = new Ladder(TEST_FRAME_LENGTH, TEST_LADDER_HEIGHT);
            //Then
            assertThat(testLadder
                    .getLines()
                    .get(0)
                    .getFrames()
                    .size())
                    .isEqualTo(TEST_FRAME_LENGTH - 1);
        }
    }


}
