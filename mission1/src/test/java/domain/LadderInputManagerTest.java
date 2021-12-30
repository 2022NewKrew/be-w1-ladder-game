package domain;

import ladder.domain.LadderInputManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderInputManagerTest {
    @DisplayName("참가자 이름 공백 테스트")
    @Test
    void TestLadderInputManager_EmptyName_ShouldThrowException() {
        //given
        String[] playersArray = {"pobi", "", "honux"};

        //when

        //then
    }

    @DisplayName("참가자 이름 길이 제한 테스트")
    @Test
    void isNameLenExceedsLimit() {

    }

    @DisplayName("사다리 높이 정수 여부 테스트")
    @Test
    void isHeightInteger() {

    }

    @DisplayName("사다리 높이 양수 여부 테스트")
    @Test
    void isHeightPositive() {

    }
}
