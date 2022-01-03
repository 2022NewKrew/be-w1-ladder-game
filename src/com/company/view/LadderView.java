package com.company.view;

import com.company.domain.LadderDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderView {
    private final List<String> nameView;
    private final List<String> resultView;
    private final List<String> ladderView;
    private final String resultListView;
    private final Map<String, String> resultFromName;

    public LadderView(LadderDTO ladderDTO) {
        this.nameView = generateNameView(ladderDTO.getNames(), 5);
        this.resultView = generateNameView(ladderDTO.getResults(), 5);
        this.ladderView = generateLadderView(ladderDTO.getLadderInfo());
        this.resultFromName = ladderDTO.getResultFromName();
        this.resultListView = generateResultListView(resultFromName, ladderDTO.getNames());
    }

    private String generateResultListView(Map<String, String> resultFromName, List<String> names) {
        StringBuilder ret = new StringBuilder();
        for (String name : names) {
            ret.append(String.format("%s : %s%n", name, resultFromName.get(name)));
        }
        return ret.toString();
    }

    public List<String> getNameView() {
        return nameView;
    }

    protected List<String> generateLadderView(List<String> ladderInfo) {
        List<String> retLadderView = new ArrayList<String>();
        for (String line : ladderInfo) {
            retLadderView.add("  |"
                    + Arrays.stream(line.split(""))
                    .map(s -> s.repeat(5))
                    .collect(Collectors.joining("|"))
                    + "|");
        }
        return retLadderView;
    }

    protected List<String> generateNameView(List<String> names, int size) {
        List<String> retNameView = new ArrayList<String>();
        for (String name : names) {
            retNameView.add(getPaddedName(name, size));
        }
        return retNameView;
    }

    protected String getPaddedName(String name, int size) {
        name = name.substring(0, Math.min(5, name.length()));
        int frontSpace = (size - name.length()) / 2;
        int backSpace = size - frontSpace - name.length();
        return " ".repeat(frontSpace) + name + " ".repeat(backSpace);
    }

    public void printLadder() {
        printNames(nameView);
        for (String line : ladderView) {
            System.out.println(line);
        }
        printNames(resultView);
    }

    public void printResultList() {
        System.out.print(resultListView);
    }

    public void printResultOfName(String name) {
        if (!resultFromName.containsKey(name)) {
            System.out.println("이름이 존재하지 않습니다.");
            return;
        }
        System.out.printf("%s : %s%n", name, resultFromName.get(name));
    }

    protected void printNames(List<String> view) {
        for (String name : view) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}

