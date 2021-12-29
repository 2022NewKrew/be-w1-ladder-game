package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;

import java.util.List;
import java.util.Scanner;

public class LadderView {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-";
    private static final String EMPTY_SPACE = " ";

    private final Scanner scanner;

    public LadderView() {
        scanner = new Scanner(System.in);
    }

    public int inputNumberOfPlayers() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void printLadder(Ladder ladder) {
        int ladderWidth = ladder.getLadderRows().size();
        for (int i = 0; i < ladderWidth; i++) {
            LadderRow ladderRow = ladder.getLadderRows().get(i);
            List<Boolean> row = ladderRow.getRow();
            printLadderRow(row);
        }
    }

    private void printLadderRow(List<Boolean> row) {
        for (int i = 0; i < row.size(); i++) {
            System.out.print(isVerticalLine(i, row.get(i)));
        }
        System.out.println();
    }

    private String isVerticalLine(int rowIndex, boolean horizontalLine) {
        if (rowIndex % 2 == 0) {
            return VERTICAL_LINE;
        }
        return horizontalLineOrEmpty(horizontalLine);
    }

    private String horizontalLineOrEmpty(boolean horizontalLine) {
        if (horizontalLine) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_SPACE;
    }
}
