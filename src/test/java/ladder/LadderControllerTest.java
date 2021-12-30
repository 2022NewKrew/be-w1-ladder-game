package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderControllerTest {

    @Test
    @DisplayName("사용자와 결과의 개수가 맞지 않는다면 에러가 발생한다.")
    void createWithMissMatch() {
        // given
        String[] playerNames = {"1", "2"};
        String[] inputRewards = {"1"};

        // when
        ThrowingCallable callable = () -> new LadderController(playerNames, inputRewards, 5);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
