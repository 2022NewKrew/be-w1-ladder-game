package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LineTest {
    @Test
<<<<<<< HEAD
    @DisplayName("[성공] Line 객체를 생성할 수 있다")
    void canMakeLine() {
        List<Boolean> line = new ArrayList<>();
        line.add(true);
        line.add(false);

        Line testLine = new Line(line);

        Assertions.assertEquals(line, testLine.getLine());
    }

    @Test
    @DisplayName("[실패] Line 생성자에 null을 넣으면 IllegalArgumentException을 던져야 한다")
=======
    @DisplayName("Should not create lines with invalid parameter (null)")
>>>>>>> 01c34da0c1a9889ac35531770c2259bd8ba26763
    void linesWithInvalidParameter() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Line(null));
    }
}
