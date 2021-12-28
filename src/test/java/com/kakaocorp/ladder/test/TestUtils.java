package com.kakaocorp.ladder.test;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.model.Node;
import com.kakaocorp.ladder.model.Rail;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static List<Node> getAllNodesRowFirst(Ladder ladder) {
        int width = ladder.getWidth();
        int height = ladder.getHeight();
        List<Node> nodes = new ArrayList<>(width * height);
        for (int i = 0; i < height; i++) {
            List<Node> partialNodes = getAllNodesFromRow(ladder, i);
            nodes.addAll(partialNodes);
        }
        return nodes;
    }

    public static List<Node> getAllNodesFromRow(Ladder ladder, int row) {
        int width = ladder.getWidth();
        List<Node> nodes = new ArrayList<>(width);
        for (int j = 0; j < width; j++) {
            Rail rail = ladder.getRailAt(j);
            Node node = rail.getNodeAt(row);
            nodes.add(node);
        }
        return nodes;
    }
}
