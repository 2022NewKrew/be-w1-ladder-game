package com.kakaocorp.ladder.service;

import com.kakaocorp.ladder.model.Direction;
import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.policy.GamePolicy;
import com.kakaocorp.ladder.test.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderServiceTest {

    private static final int HEIGHT = 4;
    private static final String TEST_LADDER_PRINTED =
            " Alpha   Bravo  Charlie  Delta    Echo  Foxtrot   Golf  \n" +
            "   |       |       |       |       |       |       |       \n" +
            "   |-------|       |       |       |       |       |       \n" +
            "   |       |       |       |       |       |       |       \n" +
            "   |       |-------|       |       |       |-------|       \n";
    private static final String[] participants = {
            "Alpha", "Bravo", "Charlie",
            "Delta", "Echo", "Foxtrot",
            "Golf",
    };

    private GamePolicy policy;
    private LadderService subject;

    @BeforeEach
    void setUp() {
        policy = Mockito.mock(GamePolicy.class);
        subject = new LadderService(policy);
    }

    @Test
    void initialize_requestedDimension() {
        Ladder result = subject.initialize(HEIGHT, participants);

        assertEquals(result.getHeight(), HEIGHT);
        assertEquals(result.getWidth(), participants.length);
    }

    @Test
    void initialize_mutualNeighbor() {
        Ladder result = subject.initialize(HEIGHT, participants);

        for (int row = 0; row < HEIGHT; row++) {
            List<Node> nodes = TestUtils.getAllNodesFromRow(result, row);
            assertMutualNeighbors(nodes);
        }
    }

    @Test
    void buildString() {
        Ladder ladder = new Ladder(HEIGHT, participants);
        buildSteps(ladder);
        Mockito.when(policy.getMaxNameLength()).thenReturn(7);

        String result = subject.buildString(ladder);

        assertEquals(TEST_LADDER_PRINTED, result);
    }

    private void assertMutualNeighbors(List<Node> nodes) {
        for (int index = 0; index < nodes.size(); index++) {
            assertMutualNeighbors(nodes, index);
        }
    }

    private void assertMutualNeighbors(List<Node> nodes, int index) {
        Node node = nodes.get(index);
        if (!node.hasNeighbor()) {
            return;
        }
        if (node.getNeighborDirection() == Direction.LEFT) {
            Node neighbor = nodes.get(index - 1);
            assertEquals(Direction.RIGHT, neighbor.getNeighborDirection());
            return;
        }
        Node neighbor = nodes.get(index + 1);
        assertEquals(Direction.LEFT, neighbor.getNeighborDirection());
    }

    private void buildSteps(Ladder ladder) {
        connect(ladder, 1, 3);
        connect(ladder, 0, 1);
        connect(ladder, 5, 3);
    }

    private void connect(Ladder ladder, int column, int row) {
        Node left = ladder.getRailAt(column).getNodeAt(row);
        Node right = ladder.getRailAt(column + 1).getNodeAt(row);
        left.setNeighbor(Direction.RIGHT, right);
        right.setNeighbor(Direction.LEFT, left);
    }
}
