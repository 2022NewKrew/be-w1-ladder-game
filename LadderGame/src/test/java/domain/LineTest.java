package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    static final int TESTNUM = 5;
    static Line line;

    @BeforeEach
    void setUp(){
        line = new Line(TESTNUM);
    }

    @Test
    void points_Empty_테스트(){
        assertEquals(line.pointsIsNotEmpty(),true);
    }

//    @Test points_마지막원소값_확인_테스트(){
//
//    }

    @Test
    void 가로선_출력_테스트() {
        assertEquals(line.isLine(true),"-----");
    }
}