package LadderGame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    private static final String BAR = "|";

    private Line line = new Line(5);

    @DisplayName("index에 따라 올바른 element를 뱉는가")
    @Test
    void getLadderElement() {
        String firstColumn = line.getLadderElement(0);
        String secondColumn = line.getLadderElement(1);

        Assertions.assertEquals(firstColumn, BAR);
        Assertions.assertNotEquals(secondColumn, BAR);
    }

    @DisplayName("옆에 bridge가 있으면 false를 반환하나")
    @Test
    void noBridgeOnLeftSideTest() {
        // 어떻게 구현해야 할지 모르겠습니다..
    }
}