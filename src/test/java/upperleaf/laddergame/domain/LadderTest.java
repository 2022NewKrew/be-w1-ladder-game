package upperleaf.laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upperleaf.laddergame.game.GameStartInfo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    final List<String> players = List.of("p1", "p2", "p3", "p4");
    final int MAX_LADDER_HEIGHT = 5;

    Ladder ladder;

    @BeforeEach
    void fixture() {
        ladder = new Ladder(new GameStartInfo(players, MAX_LADDER_HEIGHT));
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
        int lastLine = players.size() - 1;
        assertFalse(ladder.isConnectableToRight(lastLine, 0));
        assertThrows(Exception.class, () -> ladder.connectToRight(lastLine, 0));
    }

}