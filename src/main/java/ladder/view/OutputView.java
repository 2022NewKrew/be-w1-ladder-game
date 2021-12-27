package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

public class OutputView {

    private OutputView() {
    }

    public static void printLadder(Ladder result) {
        for (Line line : result.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        final StringBuilder stringBuilder = new StringBuilder("|");
        for (boolean point : line.getPoints()) {
            stringBuilder.append(getSignature(point))
                .append("|");
        }
        System.out.println(stringBuilder);
    }

    private static String getSignature(boolean point) {
        if (point) {
            return "-";
        }
        return " ";
    }
}
