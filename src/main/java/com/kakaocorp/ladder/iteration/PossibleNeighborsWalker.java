package com.kakaocorp.ladder.iteration;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Stick;

import java.util.List;

public class PossibleNeighborsWalker implements MultipleNodesWalker {

    @Override
    public void walk(Ladder ladder, Callback callback) {
        List<Stick> sticks = ladder.getSticks();
        int height = ladder.getHeight();
        for (int i = 1; i < sticks.size(); i++) {
            Stick leftStick = sticks.get(i - 1);
            Stick rightStick = sticks.get(i);
            processPossibleNeighbors(leftStick, rightStick, height, callback);
        }
    }

    private void processPossibleNeighbors(Stick leftStick, Stick rightStick, int height, Callback callback) {
        for (int i = 0; i < height; i++) {
            Node leftNode = leftStick.getNodes().get(i);
            Node rightNode = rightStick.getNodes().get(i);
            callback.process(leftNode, rightNode);
        }
    }
}
