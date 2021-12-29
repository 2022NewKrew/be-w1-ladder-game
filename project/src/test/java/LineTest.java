import laddergame.domain.Line;
import laddergame.domain.Point;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void preventDoubleStair() {
        Line line = new Line(0);
        line.addPoint(new Point(true));
        line.addPoint(new Point(true));
        System.out.println(line.toString());
        assertThat(line.toString()).isEqualTo("  |-----|     |");
    }
}