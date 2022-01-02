package test;

import domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.Player.LengthOfPlayerNameException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    @DisplayName("플레이어의 이름이 5글자를 넘으면 에러가 발생합니다")
    void checkPlayerNameLengthLonger() {
        Assertions.assertThrows(LengthOfPlayerNameException.class, () -> new Player("abcdee"));
    }

    @Test
    @DisplayName("플레이어의 이름이 0글자면 에러가 발생합니다")
    void checkPlayerNameLengthShorter() {
        Assertions.assertThrows(LengthOfPlayerNameException.class, () -> new Player(""));
    }
}