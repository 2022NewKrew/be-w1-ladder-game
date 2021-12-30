package upperleaf.laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upperleaf.laddergame.game.GameStartInfo;
import upperleaf.laddergame.game.GameStartInfoFactory;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    Ladder ladder;

    @BeforeEach
    void fixture() {
        GameStartInfoFactory factory = new GameStartInfoFactory();
        GameStartInfo info = factory.create();
        ladder = new Ladder(info);
    }

    @DisplayName("사다리 객체를 이용해서 사다리내 선들을 연결한 뒤, 연결 여부를 확인했을때 참이어야 한다.")
    @Test
    void connectTest() {
        int line = 0;
        int height = 0;
        assertFalse(ladder.isRightConnected(line, height));

        ladder.connectToRight(line, height);

        assertTrue(ladder.isRightConnected(line, height));
    }

    @DisplayName("연결 하려고 하는 선과 오른쪽 선에 연결되어있는 선이 있다면, 연결 할 수 없어야 한다.")
    @Test
    void connectableTest() {
        int line = 2;
        int height = 0;

        ladder.connectToRight(line, height);

        assertFalse(ladder.isConnectableToRight(line - 1, height));
        assertFalse(ladder.isConnectableToRight(line, height));
        assertFalse(ladder.isConnectableToRight(line + 1, height));

        assertThrows(Exception.class, () -> ladder.connectToRight(line - 1, height));
        assertThrows(Exception.class, () -> ladder.connectToRight(line, height));
        assertThrows(Exception.class, () -> ladder.connectToRight(line + 1, height));
    }

    @DisplayName("사다리에 마지막 선에서 오른쪽을 연결할 수 없다.")
    @Test
    void isNotConnectableToRightLastLine() {
        int lastLine = ladder.getPlayerNum() - 1;
        assertFalse(ladder.isConnectableToRight(lastLine, 0));
        assertThrows(Exception.class, () -> ladder.connectToRight(lastLine, 0));
    }

}