package com.kakaocorp.ladder.service;

import com.kakaocorp.ladder.iteration.RowFirstWalker;
import com.kakaocorp.ladder.iteration.MultipleNodesWalker;
import com.kakaocorp.ladder.iteration.PossibleNeighborsWalker;
import com.kakaocorp.ladder.model.Direction;
import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;

public class LadderService {

    private static final float NEIGHBOR_RATE = 0.5f;

    public static Ladder initialize(int height, int participants) {
        Ladder ladder = new Ladder(height, participants);
        MultipleNodesWalker walker = new PossibleNeighborsWalker();
        walker.walk(ladder, LadderService::connectNeighbors);
        return ladder;
    }

    public static String buildString(Ladder ladder) {
        MultipleNodesWalker walker = new RowFirstWalker();
        LadderPrinter printer = new LadderPrinter();
        walker.walk(ladder, printer);
        return printer.buildString();
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

        private final StringBuilder sb = new StringBuilder();

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

        public String buildString() {
            return sb.toString();
        }
    }
}
