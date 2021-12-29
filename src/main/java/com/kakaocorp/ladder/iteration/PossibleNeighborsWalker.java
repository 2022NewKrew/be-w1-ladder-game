package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Rail;

import java.util.List;

public class PossibleNeighborsWalker extends MultipleNodesWalker {

    public PossibleNeighborsWalker(Callback callback) {
        super(callback);
    }

    @Override
    public void walk(Ladder ladder) {
        List<Rail> rails = ladder.getSticks();
        int height = ladder.getHeight();
        for (int i = 1; i < rails.size(); i++) {
            Rail leftRail = rails.get(i - 1);
            Rail rightRail = rails.get(i);
            processPossibleNeighbors(leftRail, rightRail, height);
        }
    }

    private void processPossibleNeighbors(Rail leftRail, Rail rightRail, int height) {
        for (int i = 0; i < height; i++) {
            Node leftNode = leftRail.getNodes().get(i);
            Node rightNode = rightRail.getNodes().get(i);
            callback.process(leftNode, rightNode);
        }
    }
}
