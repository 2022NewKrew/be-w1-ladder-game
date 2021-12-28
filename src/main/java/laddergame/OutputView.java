package laddergame;

import java.util.List;

public class OutputView {
    public static void printLadder(List<Line> lineList) {
        for (Line line : lineList) {
            printLine(line);
        }
    }

    public static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder("|");
        for (boolean isConnected : line.getConnectionList()) {
            stringBuilder.append(isConnected ? "-" : " ");
            stringBuilder.append("|");
        }
        System.out.println(stringBuilder);
    }
}
