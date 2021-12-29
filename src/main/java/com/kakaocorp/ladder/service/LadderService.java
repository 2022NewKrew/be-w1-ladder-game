package com.kakaocorp.ladder.service;

import com.kakaocorp.ladder.iteration.MultipleNodesWalker;
import com.kakaocorp.ladder.iteration.PossibleNeighborsWalker;
import com.kakaocorp.ladder.iteration.RowFirstWalker;
import com.kakaocorp.ladder.model.Direction;
import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Rail;
import com.kakaocorp.ladder.model.Rule;
import com.kakaocorp.ladder.common.Strings;

public class LadderService {

    private static final float NEIGHBOR_RATE = 0.5f;

    private final Rule rule;

    public LadderService(Rule rule) {
        this.rule = rule;
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
        appendLabels(ladder, sb);
        MultipleNodesWalker.Callback cb = new LadderPrinter(sb, rule);
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

    private void appendLabels(Ladder ladder, StringBuilder sb) {
        for (int i = 0; i < ladder.getWidth(); i++) {
            Rail rail = ladder.getRailAt(i);
            String label = rail.getLabel();
            String padded = Strings.pad(label, rule.getMaxNameLength() + 1);
            sb.append(padded);
        }
        sb.append('\n');
    }

    private static class LadderPrinter implements MultipleNodesWalker.Callback {

        private final StringBuilder sb;
        private final Rule rule;

        public LadderPrinter(StringBuilder sb, Rule rule) {
            this.sb = sb;
            this.rule = rule;
        }

        @Override
        public void process(Node node1, Node node2) {
            int maxNameLength = rule.getMaxNameLength();
            if (node2 == null) {
                sb.append('\n');
                return;
            }
            if (node1 == null) {
                sb.append(" ".repeat(maxNameLength / 2));
            }
            sb.append('|');
            if (node2.hasNeighbor() && node2.getNeighborDirection() == Direction.RIGHT) {
                sb.append("-".repeat(maxNameLength));
                return;
            }
            sb.append(" ".repeat(maxNameLength));
        }
    }
}
