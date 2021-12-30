package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void getPoints() {
        // given
        final int MAX_PARTICIPANTS_NUMBER = 1000;
        Line line = new Line(MAX_PARTICIPANTS_NUMBER);

        // when
        List<Boolean> points = line.getPoints();

        // then
        // 연속한 두 간격이 모두 연결되어있으면 안되기 때문에, 적어도 한 쪽은 연결되어있지 않을 것(false)이므로 and 연산을 하면 무조건 false가 나와야 함
        // 만약 and 후 true 라면 연속된 두개의 간격이 모두 bridge, 즉 연결되어있다는 뜻이므로 사다리게임의 조건을 만족하지 않음
        for (int i = 1; i < line.getLength(); i++) {
            assertEquals(points.get(i-1) && points.get(i), false);
        }
    }
}
