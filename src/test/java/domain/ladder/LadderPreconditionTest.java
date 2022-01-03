package domain.ladder;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Ladder 검증")
@Nested
class LadderPreconditionTest {
    @DisplayName("frame의 수 검증")
    @Nested
    class FrameLengthTest {
        @DisplayName("올바른 프레임 길이가 주어졌을때 LadderPrecondition.checkFrameLength 메서드를 실행하면 예외를 던지지 않는다.")
        @Test
        void isLegalFrames() {
            //Give
            final int TEST_LEGAL_FRAME_LENGTH = 5;
            final int TEST_MIN_FRAME_LENGTH = 1;
            //When : LadderPrecondition.checkFrameLength 메서드에 TEST_LEGAL_FRAME_LENGTH, TEST_MIN_FRAME_LENGTH를 인자로 넘겼을 때
            //Then
            assertThatCode(() -> LadderPrecondition.checkFrameLength(TEST_LEGAL_FRAME_LENGTH, TEST_MIN_FRAME_LENGTH)).doesNotThrowAnyException();
        }

        @DisplayName("올바르지 못한 프레임 길이가 주어졌을때 LadderPrecondition.checkFrameLength 메서드를 실행하면 IllegalArgumentException 예외를 던진다.")
        @Test
        void isIllegalFrames() {
            //Give
            final int TEST_ILLEGAL_FRAME_LENGTH = 0;
            final int TEST_MIN_FRAME_LENGTH = 1;
            //When : LadderPrecondition.checkFrameLength 메서드에 TEST_ILLEGAL_FRAME_LENGTH, TEST_MIN_FRAME_LENGTH를 인자로 넘겼을 때
            //Then
            assertThatThrownBy(() -> LadderPrecondition.checkFrameLength(TEST_ILLEGAL_FRAME_LENGTH, TEST_MIN_FRAME_LENGTH))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("height 검증")
    @Nested
    class HeightTest {
        @DisplayName("올바른 높이가 주어졌을 때 LadderPrecondition.checkLadderHeight 메서드를 실행하면 예외를 던지지 않는다.")
        @Test
        void isLegalHeight() {
            //Give
            final int TEST_LEGAL_LADDER_HEIGHT = 5;
            final int TEST_MIN_LADDER_HEIGHT = 1;
            //When : LadderPrecondition.checkLadderHeight 메서드에 TEST_LEGAL_LADDER_HEIGHT, TEST_MIN_LADDER_HEIGHT를 인자로 넘겼을 때
            //Then
            assertThatCode(() -> LadderPrecondition.checkLadderHeight(TEST_LEGAL_LADDER_HEIGHT, TEST_MIN_LADDER_HEIGHT)).doesNotThrowAnyException();
        }

        @DisplayName("올바르지 못한 높이가 주어졌을 때 LadderPrecondition.checkLadderHeight 메서드를 실행하면 IllegalArgumentException 예외를 던진다.")
        @Test
        void isIllegalHeight() {
            //Give
            final int TEST_ILLEGAL_LADDER_HEIGHT = 0;
            final int TEST_MIN_LADDER_HEIGHT = 1;
            //When : LadderPrecondition.checkLadderHeight 메서드에 TEST_ILLEGAL_LADDER_HEIGHT, TEST_MIN_LADDER_HEIGHT를 인자로 넘겼을 때
            //Then
            assertThatThrownBy(() -> LadderPrecondition.checkLadderHeight(TEST_ILLEGAL_LADDER_HEIGHT, TEST_MIN_LADDER_HEIGHT))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}

