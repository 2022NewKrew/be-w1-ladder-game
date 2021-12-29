package com.kakaocorp.laddergame.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NameLadderTest {

    @Test
    void lineTypesPossibleTest() {
        for (int i = 0; i < 100; i++) {
            Line line = new Line(5);
            List<Boolean> lineTypes = line.getLineTypes();

            testLine(lineTypes);
        }
    }

    private void testLine(List<Boolean> lineTypes) {
        for (int j = 0; j < 3; j++) {
            Assertions.assertEquals(false, lineTypes.get(j) && lineTypes.get(j + 1));
        }
    }
}