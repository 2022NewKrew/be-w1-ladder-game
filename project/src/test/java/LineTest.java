import laddergame.domain.Line;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void preventDoubleStair() {
        Line line = new Line(0);
        line.addPoint(true);
        line.addPoint(true);
        System.out.println(line.toString());
        assertThat(line.toString()).isEqualTo("  |-----|     |");
    }
}