package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Rail;

public class RowFirstWalker extends MultipleNodesWalker {

    public RowFirstWalker(Callback callback) {
        super(callback);
    }

    @Override
    public void walk(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            processRow(ladder, i);
        }
    }

    private void processRow(Ladder ladder, int row) {
        Node left = null;
        Node right;
        for (int i = 0; i < ladder.getWidth(); i++) {
            Rail rail = ladder.getRailAt(i);
            right = rail.getNodeAt(row);
            callback.process(left, right);
            left = right;
        }
        callback.process(left, null);
    }
}
