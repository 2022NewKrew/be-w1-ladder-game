package com.kakaocorp.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RailTest {

    private static final String LABEL = "hello-world";
    private static final int HEIGHT = 5;

    private Rail subject;

    @BeforeEach
    void setUp() {
        subject = new Rail(LABEL, HEIGHT);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void getNodeAt_inRange(int index) {
        Node result = subject.getNodeAt(index);

        assertNotNull(result);
    }


    @Test
    void getNodeAt_underMinimum() {
        Executable command = () -> subject.getNodeAt(-1);

        assertThrows(IndexOutOfBoundsException.class, command);
    }

    @Test
    void getNodeAt_overMaximum() {
        Executable command = () -> subject.getNodeAt(HEIGHT);

        assertThrows(IndexOutOfBoundsException.class, command);
    }

    @Test
    void getLabel() {
        String result = subject.getLabel();

        assertEquals(LABEL, result);
    }
}
