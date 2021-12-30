package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("겹치는 라인이 없는지 확인하는 테스트")
    void overlappingLineTest(){
        //given
        Line line = new Line(100);

        //when
        String lineStr = line.toString();
//        System.out.println(lineStr);

        //then
        assertFalse(lineStr.contains("-----|-----"));
    }

}