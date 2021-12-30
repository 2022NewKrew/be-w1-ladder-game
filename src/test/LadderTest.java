import main.domain.ladder.Ladder;
import main.domain.ladder.LadderFactory;
import main.domain.ladder.RandomLadderFactory;
import main.domain.line.Line;
import main.domain.vo.LadderInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private static final LadderFactory factory = new RandomLadderFactory();

    @Test
    @DisplayName("Line객체에서 선을 그을 수 있는지 테스트")
    public void isConnectableLine() {
        // given
        Line line1 = new Line("temp", "o", 10);
        Line line2 = new Line("kain", "x", 10);
        Line line3 = new Line("honux", "o", 10);

        // when
        line1.connect(line2, 3);
        line2.connect(line3, 4);

        // then
        boolean expectFalse = line2.isConnectable(line3, 3);
        boolean expectTrue = line2.isConnectable(line3, 5);
        Assertions.assertFalse(expectFalse);
        Assertions.assertTrue(expectTrue);
    }

    @Test
    @DisplayName("플레이어 이름 5글자 제한 테스트")
    public void playerNameLengthOver5() {
        // given
        String[] playerNames = new String[]{"veryverylong", "longlongstring"};
        String[] results = new String[]{"o", "x"};
        int height = 3;

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LadderInput(playerNames, results, height));
    }

    @Test
    @DisplayName("결과 5글자 초과 테스트")
    public void resultLengthOver5() {
        // given
        String[] playerNames = new String[]{"one", "two"};
        String[] results = new String[]{"veryverylongresult", "x"};
        int height = 3;

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LadderInput(playerNames, results, height));
    }

    @Test
    @DisplayName("사다리 게임 결과값 테스트")
    public void ladderResultTest() {
        // given

        /*
            hong  chan  pyo
             |     |     |
             |-----|     |
             |     |-----|
             x     y     z
         */
        Ladder ladder = makeTestLadder();

        // when
        String resultHong = ladder.getResult(0);
        String resultChan = ladder.getResult("chan");
        String resultPyo = ladder.getResult(2);

        // then
        Assertions.assertEquals("z", resultHong);
        Assertions.assertEquals("x", resultChan);
        Assertions.assertEquals("y", resultPyo);
    }

    @Test
    @DisplayName("없는 사용자 결과 조회")
    public void getResultNotExist() {
        // given
        Ladder ladder = makeTestLadder(); // hong, chan, pyo

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> ladder.getResult("joker"));
    }

    /**
     *   hong  chan  pyo
     *   |     |     |
     *   |-----|     |
     *   |     |-----|
     *   x     y     z
     */
    private Ladder makeTestLadder() {
        Ladder ladder = new Ladder(new String[]{"hong", "chan", "pyo"}, new String[]{"x", "y", "z"}, 3);
        Line lineHong = ladder.getLine(0);
        Line lineChan = ladder.getLine(1);
        Line linePyo = ladder.getLine(2);

        lineHong.connect(lineChan, 1);
        lineChan.connect(linePyo, 2);
        return ladder;
    }
}
