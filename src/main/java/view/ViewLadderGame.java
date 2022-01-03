package view;


import domain.Item;
import domain.Ladder;
import domain.LadderGame;
import domain.RowOfStepMark;

import java.util.List;
import java.util.stream.Collectors;


public class ViewLadderGame {
    private static final int STEP_WIDTH = 5;
    private static final String STEP = "-".repeat(STEP_WIDTH);
    private static final String NO_STEP = " ".repeat(STEP_WIDTH);
    private static final String BEAM = "|";
    private static final String INPUTS_OUTPUTS_LEADING_SPACE = " ".repeat(STEP_WIDTH / 2);
    private static final String LADDER_LEADING_SPACE = " ".repeat(STEP_WIDTH - 1);

    ViewLadderGame(LadderGame ladderGame) {
        print(ladderGame.getLadderInputs());
        print(ladderGame.getLadder());
    }

    private static String getPaddedName(Item item) {
        int totalSpaceCount = STEP_WIDTH - item.name.length();
        int leftSpaceCount = totalSpaceCount / 2;
        int rightSpaceCount = totalSpaceCount - leftSpaceCount;
        return " ".repeat(leftSpaceCount) + item.name + " ".repeat(rightSpaceCount);
    }

    private void print(List<Item> items) {
        System.out.println(INPUTS_OUTPUTS_LEADING_SPACE + String.join(" ", items.stream().map(item -> getPaddedName(item)).collect(Collectors.toList())));
    }

    private void print(Ladder ladder) {
        for (var row : ladder.getState()) {
            print(row);
        }
    }

    private void print(RowOfStepMark ladderRow) {
        StringBuilder row = new StringBuilder(LADDER_LEADING_SPACE + BEAM);
        for (var isStep : ladderRow.getState()) {
            row.append(isStep ? STEP : NO_STEP);
            row.append(BEAM);
        }
        System.out.println(row);
    }
}
