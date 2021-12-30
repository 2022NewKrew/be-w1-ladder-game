import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LadderGameMainFailTest {

    @Test
    @DisplayName("실제 플레이 실패 테스트")
    public void startFailTest() {
        String input = "jeff,a,keith,binary,champ,clo,hoodie\njeff,a,keith,binar,champ,clo,hoodi\no,x,o,x,x,o,o\n6\njeff\n춘식이\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LadderGameMain ladderGameMain = new LadderGameMain();
        ladderGameMain.start();
    }
}
