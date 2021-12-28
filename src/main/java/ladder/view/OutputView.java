package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

public class OutputView {

    public OutputView() {
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder.getLines()) {
            sb.append(printLine(line)).append("\n");
        }
        System.out.println(sb);
    }

    private static String printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (String bridge : line.getBridges()) {
            sb.append(bridge);
        }
        return sb.toString();
    }
}
