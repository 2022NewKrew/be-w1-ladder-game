import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LadderGameTest {

    @Test
    @DisplayName("실제 플레이 성공 테스트")
    public void startSuccessTest(){
        String input = "5\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }

    @Test
    @DisplayName("실제 플레이 실패 테스트")
    public void startFailTest(){
        String input = "-5\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        input = "5\n6";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }

}