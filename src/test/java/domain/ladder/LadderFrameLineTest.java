package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LadderFrameLine 테스분")
class LadderFrameLineTest {
    @Nested
    @DisplayName("LadderFrameLine 클래스 생성자 테스트")
    class ConstructorTest {

        @Test
        @DisplayName("생성자가 프레임 리스트를 올바르게 생성하는지 확인")
        public void checkConstructor() {
            //Give
            final int NUMBER_OF_FRAME = 5;
            //When
            LadderFrameLine testLadderFrameLine = new LadderFrameLine(NUMBER_OF_FRAME);
            //Then
            assertThat(testLadderFrameLine.getFrames().size()).isEqualTo(NUMBER_OF_FRAME);
        }

        @Test
        @DisplayName("브릿지가 연속으로 생성되어 있는지 확인")
        public void isLegalFrames() {
            //Give
            final int NUMBER_OF_FRAME = 5;
            //When
            LadderFrameLine testLadderFrameLine = new LadderFrameLine(NUMBER_OF_FRAME);
            //Then
            assertThat(hasContinuousBridge(testLadderFrameLine.getFrames())).isTrue();
        }

        private boolean hasContinuousBridge(List<LadderFrame> frames) {
            LadderFrame previousFrame = null;
            for (LadderFrame frame : frames) {
                if (previousFrame == LadderFrame.BRIDGE && frame == LadderFrame.BRIDGE) {
                    return false;
                }
                previousFrame = frame;
            }
            return true;
        }
    }

}
