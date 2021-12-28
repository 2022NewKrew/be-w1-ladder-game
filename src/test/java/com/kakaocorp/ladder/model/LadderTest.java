package com.kakaocorp.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private static final int HEIGHT = 3;
    private static final int WIDTH = 5;

    private Ladder subject;

    @BeforeEach
    void setUp() {
        subject = new Ladder(HEIGHT, WIDTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void getRailAt_inRange(int index) {
        Rail result = subject.getRailAt(index);

        assertNotNull(result);
    }

    @Test
    void getRailAt_underMinimum() {
        Executable command = () -> subject.getRailAt(-1);

        assertThrows(IndexOutOfBoundsException.class, command);
    }

    @Test
    void getRailAt_overMaximum() {
        Executable command = () -> subject.getRailAt(WIDTH);

        assertThrows(IndexOutOfBoundsException.class, command);
    }

    @Test
    void getWidth() {
        int result = subject.getWidth();

        assertEquals(result, WIDTH);
    }

    @Test
    void getHeight() {
        int result = subject.getHeight();

        assertEquals(result, HEIGHT);
    }
}
