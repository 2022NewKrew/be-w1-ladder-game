import java.util.ArrayList;

public class LadderView {
    private final String DEFAULT_LADDER_LINE = "|";
    private final String RANDOM_LADDER_POINT = "-----";
    private final String NO_LADDER_POINT = "     ";
    private final String LEFT_MARGIN = "    ";

    private Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void print() {
        int ladderHeight = ladder.getHeight();
        for (int i = 0; i < ladderHeight; i++) {
            System.out.print(LEFT_MARGIN);
            printLadderLine(i);
        }
    }

    private void printLadderLine(int row) {
        int ladderWidth = ladder.getWidth();
        Line line = ladder.getLineByIndex(row);
        StringBuilder ladderLine = makeLadderLineString(ladderWidth, line);

        System.out.println(ladderLine);
    }

    private StringBuilder makeLadderLineString(int ladderWidth, Line line) {
        StringBuilder ladderLine = new StringBuilder();
        ladderLine.append(DEFAULT_LADDER_LINE);
        for (int i = 0; i < ladderWidth; i++) {
            Boolean flag = line.getFlagByIndex(i);
            ladderLine.append(getRandomLadderLinePoint(flag));
            ladderLine.append(DEFAULT_LADDER_LINE);
        }

        return ladderLine;
    }

    private String getRandomLadderLinePoint(Boolean flag) {
        if (flag)
            return RANDOM_LADDER_POINT;

        return NO_LADDER_POINT;
    }
}


