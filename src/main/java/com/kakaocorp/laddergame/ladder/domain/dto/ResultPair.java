package com.kakaocorp.laddergame.ladder.domain.dto;

public class ResultPair<U, V> {

    private final U first;
    private final V second;

    public ResultPair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
