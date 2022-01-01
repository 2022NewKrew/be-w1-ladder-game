package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @DisplayName("사람수가 1보다 작으면 예외 발생")
    @Test
    void createWrongNumOfPeople() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(0));
    }


    @DisplayName("points를 수정하면 예외 발생")
    @Test
    void getPoints() {
        assertThatThrownBy(() -> {
            new Line(4).getPoints().remove(0);
        })
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("points에 연속된 사다리 발판을 가진 값이 없음")
    @Test
    void validateLine() {
        assertThatCode(() -> {
            List<Point> points = new Line(11).getPoints();
            for (int i = 0; i < points.size() - 1; i++) {
                Point pointA = points.get(i);
                Point pointB = points.get(i + 1);

                validateConnectedPoint(pointA, pointB);
            }
        }).doesNotThrowAnyException();
    }

    void validateConnectedPoint(Point pointA, Point pointB) throws Exception {
        if (pointA.isStep() && pointB.isStep()) throw new Exception();
    }

}