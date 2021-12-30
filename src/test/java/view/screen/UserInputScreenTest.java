package view.screen;

import common.value.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputScreenTest {

    @DisplayName("사용자이름을 최대 5자로 설정한다.")
    @Test
    void 사용자이름을_최대_5글자만_표시한다() {
        // given
        String input = "pobipobi,honuxhonux,crongcrong,jk\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        UserInputScreen userInputScreen = new UserInputScreen();
        Players players = userInputScreen.render().getPlayers();

        // then
        for(int i = 0; i < players.getCount(); i++) {
            String playerName = players.getPlayerName(i);
            assertTrue(0 <= playerName.length() && playerName.length() <= 5);
        }
    }
}