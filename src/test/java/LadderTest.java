import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    int h = 5;
    int w = 10;
    Ladder ladder = new Ladder(h, w);

    @Test
    void 객체생성테스트() {
        Assertions.assertEquals(ladder.getHeight(), h);
        Assertions.assertEquals(ladder.getWidth(),w-1);
        Assertions.assertEquals(ladder.getCrossLines().size(), h);
    }
}