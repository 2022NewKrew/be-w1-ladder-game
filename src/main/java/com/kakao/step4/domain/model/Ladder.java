package com.kakao.step4.domain.model;

public class Ladder {
    private final Names names;
    private final Lines lines;

    public Ladder(Names names, int countOfLines) {
        this.names = names;
        this.lines = new Lines();
        this.lines.addLines(names.getSize(), countOfLines);
    }

    @Override
    public String toString() {
        return this.names.toString() + this.lines.toString();
    }
}