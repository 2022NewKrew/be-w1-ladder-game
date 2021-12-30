package upperleaf.laddergame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameStartInfoTest {

    @DisplayName("게임 설정을 생성할때 플레이어가 없거나, 값이 음수인 경우 예외가 발생한다.")
    @Test
    void infoCreateTest() {
        assertThrows(Exception.class, () -> new GameStartInfo(List.of(), List.of("r1", "r2", "r3"), 5));
        assertThrows(Exception.class, () -> new GameStartInfo(List.of("p1", "p2", "p3"), List.of("r1", "r2", "r3"), -1));
    }
}