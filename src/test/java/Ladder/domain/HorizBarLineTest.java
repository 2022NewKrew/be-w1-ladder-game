package Ladder.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizBarLineTest {
    public HorizBarLine HorizontalLine;

    private static final int WIDTH = 8;
    private static final String BLANK = "     ";

    @BeforeEach
    void setUp() {
        HorizontalLine = new HorizBarLine(WIDTH);
    }

    @Test
    void testMakingRule() {
        List<String> line = HorizontalLine.getLine();

        System.out.println(line.size());
        if (line.size() == 0) {
            return;
        }

        String prev = line.get(0);
        for (int i = 1; i < line.size(); i++) {
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
