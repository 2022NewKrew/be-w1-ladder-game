import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class LadderGameTest {
    private final LadderGame ladderGame = new LadderGame();

    @Test
    void 입력_성공(){
        final String inputStr = "10\n10";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);

        ladderGame.start();
    }

    @Test
    void 입력_실패() {
        final String inputStr = "0\n10";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalArgumentException.class, ()-> ladderGame.start());
    }

}
