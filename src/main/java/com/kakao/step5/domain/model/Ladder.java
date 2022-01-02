package com.kakao.step5.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Ladder {
    private final Names names;
    private final Results results;
    private final Lines lines;
    private final Matches matches;

    public Ladder(Names names, Results results, int countOfLines) {
        this.names = names;
        this.results = results;
        this.lines = new Lines();
        this.lines.addLines(names.getSize(), countOfLines);
        this.matches = new Matches();
        this.matches.executeMatch(names.getSize(), countOfLines, names, lines, results);
    }

    public String findMatchedResult(String name) {
        return matches.findMatchedResult(name);
    }

    @Override
    public String toString() {
        return this.names.toString() + this.lines.toString() + this.results.toString();
    }
}