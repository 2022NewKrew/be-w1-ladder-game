package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("lines를 수정하면 예외 발생")
    @Test
    void getLines() {
        Ladder ladder = new Ladder(3,4);

        assertThatThrownBy(() -> ladder.getLines().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}