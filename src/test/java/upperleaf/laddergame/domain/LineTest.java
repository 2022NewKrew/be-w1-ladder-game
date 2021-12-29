package upperleaf.laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    Line firstLine;
    Line middleLine;
    Line lastLine;

    @BeforeEach
    void fixture() {
        firstLine = new Line(0, 3, 5);
        middleLine = new Line(1, 3, 5);
        lastLine = new Line(2, 3, 5);
    }

    @DisplayName("선을 연결한 뒤, 연결 확인을 했을때 참이여야 한다.")
    @Test
    void connectToRightTest() {
        int height = 0;
        firstLine.connectToRight(height);
        assertTrue(firstLine.isRightConnected(height));

        middleLine.connectToRight(height);
        assertTrue(middleLine.isRightConnected(height));
        middleLine.connectToLeft(height);
        assertTrue(middleLine.isLeftConnected(height));

        lastLine.connectToLeft(height);
        assertTrue(lastLine.isLeftConnected(height));
    }

    @DisplayName("각 선은 자신이 첫번째 선인지, 중간 선인지, 마지막 선인지 확인할 수 있다.")
    @Test
    void lineIndexTest() {
        assertTrue(firstLine.isFirstLine());
        assertTrue(lastLine.isLastLine());

        assertFalse(middleLine.isFirstLine() || middleLine.isLastLine());
        assertFalse(firstLine.isLastLine());
        assertFalse(lastLine.isFirstLine());
    }

    @DisplayName("첫번째 선과 마지막 선은 한방향으로만 연결할 수 있다.")
    @Test
    void oneWayConnectTest() {
        int height = 0;
        assertThrows(Exception.class, () -> firstLine.connectToLeft(height));
        assertThrows(Exception.class, () -> lastLine.connectToRight(height));
    }
}