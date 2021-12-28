package com.kakaocorp.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node subject;

    @BeforeEach
    void setUp() {
        subject = new Node();
    }

    @Test
    void getNeighborDirection_initialNull() {
        Direction result = subject.getNeighborDirection();

        assertNull(result);
    }

    @Test
    void getNeighborDirection_afterSet() {
        Direction expected = Direction.LEFT;
        subject.setNeighbor(expected, new Node());

        Direction result = subject.getNeighborDirection();

        assertEquals(expected, result);
    }

    @Test
    void hasNeighbor_initialFalse() {
        boolean result = subject.hasNeighbor();

        assertFalse(result);
    }

    @Test
    void hasNeighbor_afterSetNonNull() {
        subject.setNeighbor(Direction.RIGHT, new Node());

        boolean result = subject.hasNeighbor();

        assertTrue(result);
    }

    @Test
    void hasNeighbor_afterSetNull() {
        subject.setNeighbor(Direction.RIGHT, null);

        boolean result = subject.hasNeighbor();

        assertFalse(result);
    }
}