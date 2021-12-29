package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.test.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.verify;

class PossibleNeighborsWalkerTest {

    private static final int HEIGHT = 2;
    private static final int WIDTH = 3;

    private MultipleNodesWalker.Callback callback;
    private PossibleNeighborsWalker subject;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        callback = Mockito.mock(MultipleNodesWalker.Callback.class);
        subject = new PossibleNeighborsWalker(callback);
        ladder = new Ladder(HEIGHT, WIDTH);
    }

    @Test
    void walk() {
        subject.walk(ladder);

        List<Node> nodes = TestUtils.getAllNodesRowFirst(ladder);
        for (int row = 0; row < HEIGHT; row++) {
            verifyAllPairsInRow(nodes, row);
        }
    }

    private void verifyAllPairsInRow(List<Node> nodes, int row) {
        for (int column = 1; column < WIDTH; column++) {
            Node leftNode = nodes.get(WIDTH * row + column - 1);
            Node rightNode = nodes.get(WIDTH * row + column);
            verify(callback).process(leftNode, rightNode);
        }
    }
}
