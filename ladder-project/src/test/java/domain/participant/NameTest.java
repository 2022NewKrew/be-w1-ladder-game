package domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("사람 이름이 5글자 넘을 때 확인하는 테스트")
    void nameLengthCheckTest() {
        String testCase = "baeked";
        assertThrows(IllegalArgumentException.class, () -> new Name(testCase));
    }
}