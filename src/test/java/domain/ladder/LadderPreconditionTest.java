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
            final int testLegalFrameLength = 5;
            final int testMinFrameLength = 1;
            //When : LadderPrecondition.checkFrameLength 메서드에 testLegalFrameLength, testMinFrameLength 인자로 넘겼을 때
            //Then
            assertThatCode(() -> LadderPrecondition.checkFrameLength(testLegalFrameLength, testMinFrameLength))
                    .doesNotThrowAnyException();
        }

        @DisplayName("올바르지 못한 프레임 길이가 주어졌을때 LadderPrecondition.checkFrameLength 메서드를 실행하면 IllegalArgumentException 예외를 던진다.")
        @Test
        void isIllegalFrames() {
            //Give
            final int testIllegalFrameLength = 0;
            final int testMinFrameLength = 1;
            //When : LadderPrecondition.checkFrameLength 메서드에 testIllegalFrameLength, testMinFrameLength 인자로 넘겼을 때
            //Then
            assertThatThrownBy(() -> LadderPrecondition.checkFrameLength(testIllegalFrameLength, testMinFrameLength))
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
            final int testLegalLadderHeight = 5;
            final int testMinLadderHeight = 1;
            //When : LadderPrecondition.checkLadderHeight 메서드에 testLegalLadderHeight, testMinLadderHeight 인자로 넘겼을 때
            //Then
            assertThatCode(() -> LadderPrecondition.checkLadderHeight(testLegalLadderHeight, testMinLadderHeight))
                    .doesNotThrowAnyException();
        }

        @DisplayName("올바르지 못한 높이가 주어졌을 때 LadderPrecondition.checkLadderHeight 메서드를 실행하면 IllegalArgumentException 예외를 던진다.")
        @Test
        void isIllegalHeight() {
            //Give
            final int testIllegalLadderHeight = 0;
            final int testMinLadderHeight = 1;
            //When : LadderPrecondition.checkLadderHeight 메서드에 testIllegalLadderHeight, testMinLadderHeight 인자로 넘겼을 때
            //Then
            assertThatThrownBy(() -> LadderPrecondition.checkLadderHeight(testIllegalLadderHeight, testMinLadderHeight))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}

