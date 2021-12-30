package ladder.domain;

import ladder.exception.IllegalPlayerNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("참가자의 이름은 5글자 이하여야 된다.")
    public void playerNameTest() {
        // given
        String playerName = "flip1";
        // when
        // then
        Player player = new Player(playerName);
    }

    @Test
    @DisplayName("참가자의 이름은 최소 1글자 이상이어야 된다.")
    public void minimumPlayerNameTest() {
        // given
        String playerName = "";
        // when
        Throwable exception = assertThrows(IllegalPlayerNameException.class, () -> new Player(playerName));
        // then
        assertEquals("참가자의 이름은 최소 1글자 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("참가자의 이름은 최소 1글자 이상이어야 된다.")
    public void emptyPlayerNameTest() {
        // given
        String playerName = " ";
        // when
        Throwable exception = assertThrows(IllegalPlayerNameException.class, () -> new Player(playerName));
        // then
        assertEquals("참가자의 이름은 공백일 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("참가자의 이름은 최대 5글자를 넘을 수 없다.")
    public void playerNameExceptionTest() {
        // given
        String playerName = "flip1945";

        // when
        Throwable exception = assertThrows(IllegalPlayerNameException.class, () -> new Player(playerName));

        // then
        assertEquals("참가자의 이름은 5글자까지 입력할 수 있습니다.", exception.getMessage());
    }
}