package com.kakaocorp.ladder.model;

public class Node {

    private Node neighbor = null;
    private Direction direction = null;

    public Direction getNeighborDirection() {
        return direction;
    }

    public void setNeighbor(Direction direction, Node neighbor) {
        this.neighbor = neighbor;
        this.direction = direction;
    }

    public boolean hasNeighbor() {
        return neighbor != null;
    }
}
