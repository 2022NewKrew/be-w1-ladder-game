package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;

public interface MultipleNodesWalker {

    interface Callback {

        void process(Node node1, Node node2);
    }

    void walk(Ladder ladder, Callback callback);
}
