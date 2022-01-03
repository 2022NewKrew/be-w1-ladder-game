package ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameController Test")
class GameControllerTest {

    private static GameController gc;

    @BeforeAll
    static void initialize() {
        gc = new GameController();
    }

    @DisplayName("사다리의 높이는 1 이상이어야 한다.")
    @Test
    void 최소_사다리_높이_테스트() {
        try {
            callPrivateValidationMethod("validateNumOfLine", 0);
        } catch (Exception e) {
            assertThat(e.getCause().getMessage()).isEqualTo("사다리 높이는 1 이상이어야 합니다.");
            return;
        }
        fail();
    }

    @DisplayName("플레이어의 수는 2 이상이어야 한다.")
    @Test
    void 최소_플레이어_수_테스트() {
        try {
            callPrivateValidationMethod("validateNumOfPlayers", 1);
        } catch (Exception e) {
            assertThat(e.getCause().getMessage()).isEqualTo("플레이어가 두 명 이상이어야 합니다.");
            return;
        }
        fail();
    }

    private void callPrivateValidationMethod(String methodName, int value) throws Exception {
        Method method = gc.getClass().getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(gc, value);
    }
}