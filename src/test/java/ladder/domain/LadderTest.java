package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderTest {
    @Test
    @DisplayName("[성공] Ladder 객체를 생성할 수 있다")
    void canMakeLadder() {
        List<Line> testLines = new ArrayList<>();
        testLines.add(new Line(new ArrayList<>()));
        testLines.add(new Line(new ArrayList<>()));

        Ladder testLadder = new Ladder(testLines);

        Assertions.assertEquals(testLines, testLadder.getLadder());
    }

    @Test
    @DisplayName("[실패] Ladder 생성자에 null을 넣으면 IllegalArgumentException을 던져야 한다")
    void laddersWithInvalidParameter() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ladder(null));
    }
}
