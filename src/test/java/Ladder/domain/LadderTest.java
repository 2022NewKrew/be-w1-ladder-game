package Ladder.domain;

import Ladder.DTO.InputDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<String> strArray = new ArrayList<>();
        strArray.add("foo");
        strArray.add("baaaar");
        ladder = new Ladder(new InputDTO(strArray, 4));
    }

    @Test
    void testPrintLadder() {
    }

    @AfterEach
    void tearDown() {
    }
}
