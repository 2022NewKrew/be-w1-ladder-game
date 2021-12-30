package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void initTest() {
        ladderGame = new LadderGame();
    }

    @Test
    @DisplayName("사다리 게임 결과 테스트")
    void getResultMap() {
        String names = "a,b";
        String results = "1,2";
        ladderGame.initGame(names, results, 3, () -> true);

        Map<String, String> resultMap = ladderGame.getResultMap("all");

        assertThat(resultMap.get("a"))
            .isEqualTo("2");
        assertThat(resultMap.get("b"))
            .isEqualTo("1");
    }

    @Test
    @DisplayName("사다리 게임 결과 조회 오류 테스트")
    void getResultMap2() {
        String names = "a,b";
        String results = "1,2";
        ladderGame.initGame(names, results, 3, () -> true);

        Map<String, String> resultMap = ladderGame.getResultMap("c");

        assertThat(resultMap.get("c"))
            .isEqualTo("사다리 게임에 참여한 사용자가 아니에요.");
    }

    @Test
    @DisplayName("사용자와 결과의 수가 일치하지 않는 상황")
    void initGame() {
        String names = "a,b,c";
        String results = "1,2";

        assertThrows(InputMismatchException.class,
            () -> ladderGame.initGame(names, results, 3, () -> true));
    }

    @Test
    @DisplayName("사용자가 2명 미만인 상황")
    void initGame2() {
        String names = "a";
        String results = "1";

        assertThrows(InputMismatchException.class,
            () -> ladderGame.initGame(names, results, 3, () -> true));
    }
}
