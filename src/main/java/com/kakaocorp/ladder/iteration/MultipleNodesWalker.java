package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;

public abstract class MultipleNodesWalker {

    protected Callback callback;

    public MultipleNodesWalker(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {

        void process(Node node1, Node node2);
    }

    public abstract void walk(Ladder ladder);
}
