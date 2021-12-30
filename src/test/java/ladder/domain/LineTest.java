package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    // makeLine Test
//    @Test
//    void makeLineTest() {
//    }
    // checkPreviousPoint Test
    @Test
    void checkPreviousPointNormalTest() {
        Line line = new Line(2);
        Boolean[] point = {true};
        line.setPoint(point);
        Assertions.assertEquals(false, line.checkPreviousPoint(1));
    }
    // toString Test
//    @Test
//    void toStringTest() {
//    }

}