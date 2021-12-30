package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class LadderGameTest {
    private LadderGame ladderGame ;

//    @BeforeAll

    @Test
    void 입력_성공(){
//        final String inputStr = "10\n10";
        final String inputStr = "aaaaaaa,bbbbbbb,c,dd,eee,ffff\n10";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);

        ladderGame = new LadderGame();
        ladderGame.start();
    }

    @Test
    void 입력_실패() {
        final String inputStr = "\n10";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);

        ladderGame = new LadderGame();
        Assertions.assertThrows(IllegalArgumentException.class, ()-> ladderGame.start());
    }

}
