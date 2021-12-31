package LadderGame.domain.Ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Line 테스트")
class LineTest {

    private final int LADDER_WIDTH = 10000;

    @Test
    @DisplayName("마지막 인덱스의 사다리는 오른쪽 사다리가 존재하지 않는다.")
    public void 마지막_인덱스_사다리_테스트() throws Exception{
        //given
        Line line = new Line(LADDER_WIDTH);
        Method method = line.getClass().getDeclaredMethod("makeRandomLadder", int.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(line, LADDER_WIDTH-1);

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("직전에 사다리가 있으면 사다리를 그릴 수 없다.")
    public void 직전_사다리_유뮤_테스트() throws Exception{
        //given
        Line line = new Line(LADDER_WIDTH);
        List<Integer> connectionPoints = line.getConnectionPoints();
        connectionPoints.set(0, 1);
        connectionPoints.set(1, 0);

        Method method = line.getClass().getDeclaredMethod("makeRandomLadder", int.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(line, 1);

        //then
        assertFalse(result);
    }
}
