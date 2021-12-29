package rubam.step2;

import java.util.List;

public class LadderPrinter {

    static void printLadder(Ladder ladder) {
        List<Line> ladderData = ladder.getLadderData();
        for (Line line : ladderData) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder("|");
        for (Boolean b : line.getLineData()) {
            sb.append(lineLocationCheck(b));
        }
        System.out.println(sb);
    }

    private static String lineLocationCheck(Boolean current) {
        if (current)
            return "-|";
        return " |";
    }
}
