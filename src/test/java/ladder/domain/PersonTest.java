package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @DisplayName("이름의 길이가 1글자 이상 5글자 이하인 경우 테스트")
    @Test
    void PersonNameLengthSuccess() {
        String name = "may";
        assertDoesNotThrow(() -> new Person(name));
    }

    @DisplayName("이름의 길이가 1글자 미만인 경우 테스트")
    @Test
    void PersonNameLengthUnderFail() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> new Person(name));
    }

    @DisplayName("이름의 길이가 5글자 초과인 경우 테스트")
    @Test
    void PersonNameLengthOverFail() {
        String name = "reynold";
        assertThrows(IllegalArgumentException.class, () -> new Person(name));
    }
}