package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Stick;

import java.util.List;

public class PossibleNeighborsWalker implements MultipleNodesWalker {

    @Override
    public void walk(Ladder ladder, Callback callback) {
        List<Stick> sticks = ladder.getSticks();
        for (int i = 1; i < sticks.size(); i++) {
            Stick leftStick = sticks.get(i - 1);
            Stick rightStick = sticks.get(i);
            for (int j = 0; j < ladder.getHeight(); j++) {
                Node leftNode = leftStick.getNodes().get(j);
                Node rightNode = rightStick.getNodes().get(j);
                callback.process(leftNode, rightNode);
            }
        }
    }
}
