package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("사다리 라인 연속해서 그리는 경우 예외처리 로직 테스트")
    @Test
    public void 연속된_사다리라인_확인() {
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