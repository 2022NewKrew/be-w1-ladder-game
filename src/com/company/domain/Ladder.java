package com.company.domain;

import com.company.view.LadderView;

import java.util.*;

public class Ladder {
    private static final String[] PATTERN = {"- ", " "};
    private final Random random;

    private final LadderDTO ladderDTO;
    private final LadderView ladderView;

    public Ladder(String[] names, String[] results, int height) {
        random = new Random();
        List<String> ladderInfo = makeNewLadder(names.length, height);
        ladderDTO = new LadderDTO(names, results, ladderInfo, generateResult(names, results, ladderInfo));
        ladderView = new LadderView(ladderDTO);
    }

    public LadderDTO getLadderDTO() {
        return ladderDTO;
    }

    public LadderView getLadderView() {
        return ladderView;
    }

    protected List<String> makeNewLadder(int numPeople, int height) {
        List<String> newLadder = new ArrayList<String>();
        for (int y = 0; y < height; y++) {
            newLadder.add(makeNewLine(numPeople - 1));
        }
        return newLadder;
    }

    protected String makeNewLine(int width) {
        StringBuilder ret = new StringBuilder();
        while (ret.length() < width) {
            ret.append(PATTERN[random.nextInt(2)]);
        }
        return ret.substring(0, width);
    }

    public void printLadder() {
        System.out.println("<사다리 결과>");
        ladderView.printLadder();
    }

    public void printResultList() {
        ladderView.printResultList();
    }

    public void printResultOfName(String name) {
        ladderView.printResultOfName(name);
    }

    public Map<String, String> generateResult(String[] names, String[] results, List<String> ladderInfo) {
        Map<String, String> ret = new HashMap<String, String>();
        List<Integer> indices = new ArrayList<Integer>(names.length);
        for (int i = 0; i < names.length; i++) indices.add(i);

        ladderInfo.forEach(line -> climb(indices, line));

        for (int i = 0; i < indices.size(); i++) {
            ret.put(names[indices.get(i)], results[i]);
        }

        return ret;
    }

    public void climb(List<Integer> indices, String line) {
        for (int i = 0; i < line.length(); i++) {
            lineSwap(indices, line.charAt(i), i);
        }
    }

    public void lineSwap(List<Integer> indices, char line, int idx) {
        if (line == '-') Collections.swap(indices, idx, idx + 1);
    }
}

