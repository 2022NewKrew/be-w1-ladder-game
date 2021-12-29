package com.kakaocorp.ladder.service;

import com.kakaocorp.ladder.iteration.RowFirstWalker;
import com.kakaocorp.ladder.iteration.MultipleNodesWalker;
import com.kakaocorp.ladder.iteration.PossibleNeighborsWalker;
import com.kakaocorp.ladder.model.Direction;
import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;

public class LadderService {

    private static final float NEIGHBOR_RATE = 0.5f;

    public static Ladder initialize(int height, int width) {
        Ladder ladder = new Ladder(height, width);
        MultipleNodesWalker.Callback cb = LadderService::connectNeighbors;
        MultipleNodesWalker walker = new PossibleNeighborsWalker(cb);
        walker.walk(ladder);
        return ladder;
    }

    public static String buildString(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        MultipleNodesWalker.Callback cb = new LadderPrinter(sb);
        MultipleNodesWalker walker = new RowFirstWalker(cb);
        walker.walk(ladder);
        return sb.toString();
    }

    private static void connectNeighbors(Node node1, Node node2) {
        if (node1.hasNeighbor() || node2.hasNeighbor()) {
            return;
        }
        if (Math.random() > NEIGHBOR_RATE) {
            return;
        }
        node1.setNeighbor(Direction.RIGHT, node2);
        node2.setNeighbor(Direction.LEFT, node1);
    }

    private static class LadderPrinter implements MultipleNodesWalker.Callback {

        private final StringBuilder sb;

        public LadderPrinter(StringBuilder sb) {
            this.sb = sb;
        }

        @Override
        public void process(Node node1, Node node2) {
            if (node2 == null) {
                sb.append('\n');
                return;
            }
            sb.append('|');
            if (node2.hasNeighbor() && node2.getNeighborDirection() == Direction.RIGHT) {
                sb.append('-');
                return;
            }
            sb.append(' ');
        }
    }
}
