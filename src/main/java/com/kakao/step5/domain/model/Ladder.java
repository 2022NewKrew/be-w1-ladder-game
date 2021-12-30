package com.kakao.step5.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Ladder {
    private final Names names;
    private final Results results;
    private final int countOfLines;
    private final Lines lines;
    private final Map<String, String> matches;

    public Ladder(Names names, Results results, int countOfLines) {
        this.names = names;
        this.results = results;
        this.countOfLines = countOfLines;
        this.lines = new Lines();
        this.lines.addLines(names.getSize(), countOfLines);

        this.matches = new HashMap<>();
        executeMatch(names.getSize());
    }

    private void executeMatch(int countOfPeople) {
        for (int i = 0; i < countOfPeople; i++) {
            matchCurrentPerson(i);
        }
    }

    private void matchCurrentPerson(int personIndex) {
        int resultIndex = personIndex;

        for (int i = 0; i < this.countOfLines; i++) {
            resultIndex = this.lines.lineOf(i).checkNextIndex(resultIndex);
        }

        this.matches.put(this.names.nameOf(personIndex), this.results.resultOf(resultIndex));
    }

    public String findMatchedResult(String name) {
        if (name.equals("all")) {
            return allMatchedResult();
        }

        if (matches.get(name) == null) {
            return "해당 인원은 존재하지 않습니다.";
        }

        return matches.get(name);
    }

    private String allMatchedResult() {
        StringBuilder sb = new StringBuilder();

        matches.forEach((name, result) -> sb.append(name).append(": ").append(result).append("\n"));

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.names.toString() + this.lines.toString() + this.results.toString();
    }
}