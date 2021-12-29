package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Rail;

public class PossibleNeighborsWalker extends MultipleNodesWalker {

    public PossibleNeighborsWalker(Callback callback) {
        super(callback);
    }

    @Override
    public void walk(Ladder ladder) {
        int height = ladder.getHeight();
        for (int i = 1; i < ladder.getWidth(); i++) {
            Rail leftRail = ladder.getRailAt(i - 1);
            Rail rightRail = ladder.getRailAt(i);
            processPossibleNeighbors(leftRail, rightRail, height);
        }
    }

    private void processPossibleNeighbors(Rail leftRail, Rail rightRail, int height) {
        for (int i = 0; i < height; i++) {
            Node leftNode = leftRail.getNodeAt(i);
            Node rightNode = rightRail.getNodeAt(i);
            callback.process(leftNode, rightNode);
        }
    }
}
