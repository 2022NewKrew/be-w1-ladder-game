package com.kakao.step5.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Matches {
    private final Map<String, String> matches;

    public Matches() {
        this.matches = new HashMap<>();
    }

    public Matches (Map<String, String> matches) {
        this.matches = matches;
    }

    public void executeMatch(int countOfPeople, int countOfLines,
                             Names names, Lines lines, Results results) {
        for (int i = 0; i < countOfPeople; i++) {
            matchCurrentPerson(i, countOfLines, names, lines, results);
        }
    }

    private void matchCurrentPerson(int personIndex, int countOfLines,
                                    Names names, Lines lines, Results results) {
        int resultIndex = personIndex;

        for (int i = 0; i < countOfLines; i++) {
            resultIndex = lines.lineOf(i).checkNextIndex(resultIndex);
        }

        this.matches.put(names.nameOf(personIndex), results.resultOf(resultIndex));
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
}
