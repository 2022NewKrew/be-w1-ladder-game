package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Stick;

import java.util.List;

public class RowFirstWalker implements MultipleNodesWalker {

    @Override
    public void walk(Ladder ladder, Callback callback) {
        List<Stick> sticks = ladder.getSticks();
        for (int i = 0; i < ladder.getHeight(); i++) {
            processRow(sticks, i, callback);
        }
    }

    private void processRow(List<Stick> sticks, int row, Callback callback) {
        Node left = null;
        Node right;
        for (Stick stick : sticks) {
            right = stick.getNodes().get(row);
            callback.process(left, right);
            left = right;
        }
        callback.process(left, null);
    }
}
