import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LadderGameMainSuccessTest {

    @Test
    @DisplayName("실제 플레이 성공 테스트")
    public void startSuccessTest() {
        String input = "jeff,a,keith,binar,champ,clo,hoodi\no,x,o,x,x,o,o\n6\nall\n춘식이\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LadderGameMain ladderGameMain = new LadderGameMain();
        ladderGameMain.start();
    }



}