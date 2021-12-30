package preconditions;


import domain.ladder.LadderPrecondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Ladder 검증")
@Nested
class LadderPreconditionTest {

    public static final int TEST_LEGAL_LADDER_HEIGHT = 5;
    public static final int TEST_LEGAL_FRAME_LENGTH = 5;
    public static final int TEST_ILLEGAL_LADDER_HEIGHT = 0;
    public static final int TEST_ILLEGAL_FRAME_LENGTH = 0;
    public static final int TEST_MIN_FRAME_LENGTH = 1;
    public static final int TEST_MIN_LADDER_HEIGHT = 1;

    @DisplayName("frame의 수 검증")
    @Nested
    class FrameLengthTest {
        @DisplayName("프레임의 길이가 문제 없을때는 예외를 던지지 않음")
        @Test
        void isLegalFrames() {
            assertThatCode(() -> LadderPrecondition.checkFrameLength(TEST_LEGAL_FRAME_LENGTH, TEST_MIN_FRAME_LENGTH)).doesNotThrowAnyException();
        }

        @DisplayName("프레임의 길이가 문제 있을 때 IllegalArgumentException을 던짐")
        @Test
        void isIllegalFrames() {
            assertThatThrownBy(() -> LadderPrecondition.checkFrameLength(TEST_ILLEGAL_FRAME_LENGTH, TEST_MIN_FRAME_LENGTH))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("height 검증")
    @Nested
    class HeightTest {
        @DisplayName("높이가 문제 없을 때는 예외를 던지지 않음")
        @Test
        void isLegalHeight() {
            assertThatCode(() -> LadderPrecondition.checkLadderHeight(TEST_LEGAL_LADDER_HEIGHT, TEST_MIN_LADDER_HEIGHT)).doesNotThrowAnyException();
        }

        @DisplayName("높이가 문제 있을 때 IllegalArgumentException을 던짐 ")
        @Test
        void isIllegalHeight() {
            assertThatThrownBy(() -> LadderPrecondition.checkLadderHeight(TEST_ILLEGAL_LADDER_HEIGHT, TEST_MIN_LADDER_HEIGHT))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}

