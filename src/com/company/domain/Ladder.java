package com.company.domain;

import com.company.view.LadderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    private static final String[] PATTERN = {"- ", " "};
    private final Random random;

    private final LadderDTO ladderDTO;
    private final LadderView ladderView;

    public Ladder(String[] names, int height) {
        random = new Random();
        List<String> fixedNames = Arrays.stream(names)
                .map(s -> s.substring(0, Math.min(s.length(), 5)))
                .collect(Collectors.toList());
        List<String> ladderInfo = makeNewLadder(fixedNames.size(), height);

        ladderDTO = new LadderDTO(fixedNames, ladderInfo);
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
        ladderView.printLadder();
    }
}

