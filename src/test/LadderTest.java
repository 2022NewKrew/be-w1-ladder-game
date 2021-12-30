import main.domain.ladder.Ladder;
import main.domain.ladder.LadderFactory;
import main.domain.ladder.RandomLadderFactory;
import main.domain.line.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private static final LadderFactory factory = new RandomLadderFactory();

    @Test
    @DisplayName("Line객체에서 선을 그을 수 있는지 테스트")
    public void isConnectableLine() {
        // given
        Line line1 = new Line("temp", 10);
        Line line2 = new Line("kain", 10);
        Line line3 = new Line("honux", 10);

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
    public void playerNameValidTest() {
        // given
        Ladder ladder = factory.createLadder(new String[]{"carrot1234", "verylongname"}, 5);

        // when
        String carrot1234 = ladder.getLine(0).getName();
        String verylongname = ladder.getLine(1).getName();

        // then
        Assertions.assertTrue(carrot1234.length() <= 5);
        Assertions.assertTrue(verylongname.length() <= 5);
    }

}
