package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    static final int TESTNUM = 5;

    @Test
    void getRandomAndNotDuplicate() {

    }

    @Test
    void 가로선_출력_테스트() {
        Line line = new Line(TESTNUM);
        assertEquals(line.isLine(true),"-----");
    }
}