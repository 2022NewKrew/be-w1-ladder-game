package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.test.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.verify;

class RowFirstWalkerTest {

    private static final int HEIGHT = 2;
    private static final int WIDTH = 3;

    private MultipleNodesWalker.Callback callback;
    private RowFirstWalker subject;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        callback = Mockito.mock(MultipleNodesWalker.Callback.class);
        subject = new RowFirstWalker(callback);
        ladder = new Ladder(HEIGHT, WIDTH);
    }

    @Test
    void walk() {
        subject.walk(ladder);

        List<Node> nodes = TestUtils.getAllNodesRowFirst(ladder);
        for (int row = 0; row < HEIGHT; row++) {
            Node firstNode = nodes.get(WIDTH * row);
            Node lastNode = nodes.get(WIDTH * (row + 1) - 1);
            verify(callback).process(null, firstNode);
            verifyAllPairsInRow(nodes, row);
            verify(callback).process(lastNode, null);
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
