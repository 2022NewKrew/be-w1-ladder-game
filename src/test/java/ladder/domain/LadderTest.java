package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("사다리 상태를 문자열로 변환하였을 때, 라인의 수는 사다리의 높이와 같고, 한 라인의 '|'의 개수는 사다리의 폭의 개수 + 1와 같아야 한다.")
    @Test
    void testToString() {
        // given
        int width = 3, height = 4;
        Ladder ladder = new Ladder(width, height);

        // when
        String result = ladder.toString();

        // then
        List<String> lines = Arrays.asList(result.split("\n"));
        assertEquals(height, lines.size());
        for (String line : lines) {
            assertEquals(width + 1, line.chars().filter(c -> c == '|').count());
        }
    }
}