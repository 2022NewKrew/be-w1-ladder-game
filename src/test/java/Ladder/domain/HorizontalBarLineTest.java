package Ladder.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalBarLineTest {
    public HorizontalBarLine HorizontalLine;

    private static final int REPEAT = 5;
    private static final int WIDTH = 8;
    private static final String BLANK = " ".repeat(REPEAT);
    private static final int PADDING_LEN = 2;

    @BeforeEach
    void setUp() {
        HorizontalLine = new HorizontalBarLine(WIDTH);
    }

    @Test
    void testMakingRule() {
        List<String> line = HorizontalLine.getPrintLine();

        if (line.size() == 0) {
            return;
        }

        String prev = line.get(PADDING_LEN);
        for (int i = PADDING_LEN + 2; i < line.size() - PADDING_LEN; i += 2) {
            String cur = line.get(i);
            checkConsecutiveString(prev, cur);
            prev = cur;
        }
    }

    void checkConsecutiveString(String str1, String str2) {
        if (str1.equals(str2)) {
            assertThat(str1).isEqualTo(BLANK);
        }
    }

    @AfterEach
    void tearDown() {
    }
}
