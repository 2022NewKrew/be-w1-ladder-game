package LadderGame.domain.Player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("플레이어 테스트")
class PlayerTest {

    @Test
    @DisplayName("플레이어 이름 5글자 이하인지 테스트")
    public void 플레이어_이름_테스트(){
        //given
        String name = "ABCDE";

        //when
        Player player = new Player(name);

        //then
        assertEquals(player.name, name);
    }

    @Test
    @DisplayName("플레이어 이름 5글자를 초과할 때 테스트")
    public void 플레이어_이름_초과_테스트(){
        //given
        String name = "ABCDEFGHI";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player(name));

        //then
        assertEquals(exception.getMessage(), "5글자 이상의 이름이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("플레이어 이름 공백일 때 테스트")
    public void 플레이어_이름_공백_테스트(){
        //given
        String name = "";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player(name));

        //then
        assertEquals(exception.getMessage(), "플레이어 이름은 1글자 이상이어야 합니다.");
    }
}