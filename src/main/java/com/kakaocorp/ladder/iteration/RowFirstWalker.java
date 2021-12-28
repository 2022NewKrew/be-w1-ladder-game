package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Rail;

import java.util.List;

public class RowFirstWalker extends MultipleNodesWalker {

    public RowFirstWalker(Callback callback) {
        super(callback);
    }

    @Override
    public void walk(Ladder ladder) {
        List<Rail> rails = ladder.getSticks();
        for (int i = 0; i < ladder.getHeight(); i++) {
            processRow(rails, i);
        }
    }

    private void processRow(List<Rail> rails, int row) {
        Node left = null;
        Node right;
        for (Rail rail : rails) {
            right = rail.getNodes().get(row);
            callback.process(left, right);
            left = right;
        }
        callback.process(left, null);
    }
}
