package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("라인을 화면에 출력하기 위한 문자열로 변환하는 테스트")
    @Test
    void testToString() {
        // given
        Line line = new Line(Arrays.asList(true, false, true, false, false));

        // when
        String result = line.toString();

        // then
        assertEquals("  |-----|     |-----|     |     |", result);
    }

    // private 메서드 테스트
    @DisplayName("이전에 연결되어 있으면, 다음은 연결되면 안된다.")
    @Test
    void testAddRandomBooleanIfPrevNotConnected() throws Exception {
        Line line = Line.createRandomLine(0);
        Method addRandomBooleanIfPrevNotConnected = Line.class.getDeclaredMethod("addRandomBooleanIfPrevNotConnected", List.class);
        addRandomBooleanIfPrevNotConnected.setAccessible(true);
        List<Boolean> connected = new ArrayList<>();
        connected.add(true);

        addRandomBooleanIfPrevNotConnected.invoke(line, connected);
        boolean lastConnected = connected.get(connected.size() - 1);

        assertFalse(lastConnected);
    }

    // 랜덤으로 라인이 생성되기 때문에 100번 반복한다. -> 시간 오래 걸림!
    @DisplayName("랜덤으로 라인을 생성할 때, 겹치는 부분이 없어야 한다.")
    @RepeatedTest(100)
    void createRandomLineOverlappedTest() {
        // given
        Line line = Line.createRandomLine(100);

        // when
        boolean result = line.toString().contains("|-----|-----|");

        // then
        assertFalse(result);
    }
}