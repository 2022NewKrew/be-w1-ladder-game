package LadderGame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("올바른 사다리 높이가 입력되는지 확인")
    @Test
    void checkValidLadderRow() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            new Ladder("abc,der,ttt",0);
        });
        Assertions.assertEquals(e.getMessage(), "사다리의 높이는 0보다 커야합니다.");
    }
}