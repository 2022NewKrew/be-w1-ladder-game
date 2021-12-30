package laddergame.ladder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    static Line line;

    @BeforeEach
    void setUp(){
        line = new Line(4);
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void haveLine() {
        ArrayList<Boolean> testLine = line.getLine();
        for(int i=1;i<testLine.size()-1;i++){
            assertFalse(testLine.get(i-1)&&testLine.get(i));
        }
    }
}