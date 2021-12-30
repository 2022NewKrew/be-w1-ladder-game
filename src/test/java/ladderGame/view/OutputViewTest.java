package ladderGame.view;

import ladderGame.domain.Player;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private static final String TEST_PLAYER_NAME_STRING = "test1,tes2,te3,t4,5";
    private static final String REAL_RESULT_PLAYER_NAME_STRING = "test1  tes2   te3    t4     5 ";

    @Test
    void drawLadderGame() throws Exception {
        final Player player = new Player(TEST_PLAYER_NAME_STRING);

        final Method method = OutputView.class.getDeclaredMethod("drawPlayerName", Player.class);
        method.setAccessible(true);

        String testResult = (String) method.invoke(OutputView.class, player);
        assertEquals(REAL_RESULT_PLAYER_NAME_STRING, testResult);
    }
}
