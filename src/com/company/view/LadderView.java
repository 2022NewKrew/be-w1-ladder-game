package com.company.view;

import com.company.domain.LadderDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderView {
    private final List<String> nameView;
    private final List<String> ladderView;

    public LadderView(LadderDTO ladderDTO) {
        this.nameView = generateNameView(ladderDTO.getNames(), 5);
        this.ladderView = generateLadderView(ladderDTO.getLadderInfo());
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
        int frontSpace = (size - name.length()) / 2;
        int backSpace = size - frontSpace - name.length();
        return " ".repeat(frontSpace) + name + " ".repeat(backSpace);
    }

    public void printLadder() {
        printNames();
        for (String line : ladderView) {
            System.out.println(line);
        }
    }

    protected void printNames() {
        for (String name : nameView) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}

