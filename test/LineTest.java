import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("Line 객체에서 선을 그릴 수 있는지 판단하는 로직 정상 작동 테스트")
    @Test
    public void makeLine() {
        //given
        int cnt = 1000;

        while(cnt-- > 0){
            //when
            Line TestLine = new Line(5);

            //then
            List<Boolean> line = TestLine.getLineToList();
            for (int i = 1; i < line.size(); i++) {
                assertFalse(line.get(i - 1) && line.get(i));
            }
        }
    }
}