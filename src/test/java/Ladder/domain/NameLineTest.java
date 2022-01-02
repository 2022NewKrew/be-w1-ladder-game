package Ladder.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NameLineTest {
    private NameLine testNameLine;

    private static final String BLANK = "";
    private static final String SAMPLE = "a";
    private final int NAME_LEN = 5;

    @BeforeEach
    void setUp() {
        List<String> nameArray = new ArrayList<>();

        //adding test names
        nameArray.add(BLANK);
        nameArray.add(SAMPLE.repeat(NAME_LEN - 1));
        nameArray.add(SAMPLE.repeat(NAME_LEN));
        nameArray.add(SAMPLE.repeat(NAME_LEN + 1));

        testNameLine = new NameLine(nameArray);
    }

    @Test
    void testNameLen() {
        for (String name : testNameLine.getPrintLine()) {
            assertThat(name.length()).isLessThanOrEqualTo(NAME_LEN);
        }
    }

    @AfterEach
    void tearDown() {
    }
}
