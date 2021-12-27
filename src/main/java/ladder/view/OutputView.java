package ladder.view;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;

public class OutputView {

    private OutputView() {}

    public static void printResult(Ladder result) {
        List<Line> lines = result.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<Boolean> points = line.getPoints();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        for (boolean point : points) {
            String value;
            if (point) {
                value = "-";
            } else {
                value = " ";
            }
            stringBuilder.append(value);
            stringBuilder.append("|");
        }

        System.out.println(stringBuilder);;
    }
}
