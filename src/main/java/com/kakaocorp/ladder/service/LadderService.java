package com.kakaocorp.ladder.service;

import com.kakaocorp.ladder.iteration.RowFirstWalker;
import com.kakaocorp.ladder.iteration.MultipleNodesWalker;
import com.kakaocorp.ladder.iteration.PossibleNeighborsWalker;
import com.kakaocorp.ladder.model.Direction;
import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.policy.GamePolicy;

public class LadderService {

    private static final float NEIGHBOR_RATE = 0.5f;

    private final GamePolicy policy;

    public LadderService(GamePolicy policy) {
        this.policy = policy;
    }

    public Ladder initialize(int height, String[] participants) {
        Ladder ladder = new Ladder(height, participants);
        MultipleNodesWalker.Callback cb = this::connectNeighbors;
        MultipleNodesWalker walker = new PossibleNeighborsWalker(cb);
        walker.walk(ladder);
        return ladder;
    }

    public String buildString(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        MultipleNodesWalker.Callback cb = new LadderPrinter(sb, policy);
        MultipleNodesWalker walker = new RowFirstWalker(cb);
        walker.walk(ladder);
        return sb.toString();
    }

    private void connectNeighbors(Node node1, Node node2) {
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
        private final GamePolicy policy;

        public LadderPrinter(StringBuilder sb, GamePolicy policy) {
            this.sb = sb;
            this.policy = policy;
        }

        @Override
        public void process(Node node1, Node node2) {
            if (node2 == null) {
                sb.append('\n');
                return;
            }
            sb.append('|');
            if (node2.hasNeighbor() && node2.getNeighborDirection() == Direction.RIGHT) {
                sb.append("-".repeat(policy.getMaxNameLength()));
                return;
            }
            sb.append(" ".repeat(policy.getMaxNameLength()));
        }
    }
}
