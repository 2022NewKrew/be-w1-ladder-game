package step_4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LadderConnectionTest {
    @Test
    @DisplayName("한 라인에서 왼쪽에 연결선이 있을 때 정상적으로 탐지하는지에 대한 테스트")
    void isLeftConnected() {
        // given
        final String[] names = {"mino", "andy", "jeff", "raon", "keith"};
        final int width = names.length - 1;
        final int height = 5;

        final int index = new Random().nextInt(width - 1);
        LadderConnection ladderConnection = LadderConnection.initBySize(width);
        ladderConnection.setConnect(index, true);

        // when
        int indexOfConnectionFail = 0;
        for (int i = 0; i < width; i++) {
            if (ladderConnection.isLeftConnected(i)) {
                indexOfConnectionFail = i;
                break;
            }
        }

        // then
        assertNotEquals(0, indexOfConnectionFail);
        assertEquals(index, indexOfConnectionFail - 1);
    }
}