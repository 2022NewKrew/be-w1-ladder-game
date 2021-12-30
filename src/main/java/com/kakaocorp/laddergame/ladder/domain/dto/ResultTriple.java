package com.kakaocorp.laddergame.ladder.domain.dto;

public class ResultTriple<U, V, X> {

    private final U first;
    private final V second;
    private final X third;

    public ResultTriple(U first, V second, X third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public X getThird() {
        return third;
    }
}
