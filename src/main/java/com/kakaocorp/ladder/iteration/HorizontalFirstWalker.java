package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Stick;

public class HorizontalFirstWalker implements MultipleNodesWalker {

    @Override
    public void walk(Ladder ladder, Callback callback) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            Node left = null;
            Node right;
            for (Stick stick : ladder.getSticks()) {
                right = stick.getNodes().get(i);
                callback.process(left, right);
                left = right;
            }
            callback.process(left, null);
        }
    }
}
