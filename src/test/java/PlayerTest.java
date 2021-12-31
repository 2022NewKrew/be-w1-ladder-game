package test.java;

import main.java.domain.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlayerTest {
    @ParameterizedTest(name = "이름 길이 제한 Test")
    @ValueSource(strings = {"sooncheol", "kakaocommerce"})
    public void 이름_길이_제한_Test(String input) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Player(input));
        assertEquals("이름은 최대 5글자입니다.",illegalArgumentException.getMessage());
    }

    @ParameterizedTest(name = "이름_공백_Test")
    @ValueSource(strings = {"do g", "ap ple", "po bi"})
    public void 이름_공백_Test(String input) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Player(input));
        assertEquals("이름은 공백을 포함할 수 없습니다.",illegalArgumentException.getMessage());
    }
}