package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("사람수가 1보다 작으면 예외 발생")
    @Test
    void createWrongNumOfPeople() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(0, 3));
    }

    @DisplayName("높이 1보다 작으면 예외 발생")
    @Test
    void createWrongHeight() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(3, 0));
    }

    @DisplayName("lines를 수정하면 예외 발생")
    @Test
    void getLines() {
        Ladder ladder = new Ladder(3, 4);

        assertThatThrownBy(() -> ladder.getLines().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}