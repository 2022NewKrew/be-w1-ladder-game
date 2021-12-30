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
        assertEquals(line.cellsIsFill(),true);
    }

    @Test
    void 가로선_연속2개방지_테스트(){
        int lastindex = line.getCells().size() - 1;
        if(line.getCells().get(lastindex)){
            assertEquals(line.generateCellNotDuplicate(), false);
        }
    }

}