package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    Line line = new Line(5);
    @Test
    // isConnected 메소드 테스트
    void isConnected() {
        if(line.getLines().get(0))
            assertTrue(!line.isConnected(1));
    }
}