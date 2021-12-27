package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Stick;

import java.util.List;

public class HorizontalFirstWalker implements MultipleNodesWalker {

    @Override
    public void walk(Ladder ladder, Callback callback) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            List<Stick> sticks = ladder.getSticks();
            Node left = null;
            Node right = null;
            for (Stick stick : sticks) {
                right = stick.getNodes().get(i);
                callback.process(left, right);
                left = right;
                right = null;
            }
            callback.process(left, right);
        }
    }
}
