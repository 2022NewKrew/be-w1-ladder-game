package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class DrawLadder {
    public static String drawLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append(formatNames(ladder.getPeopleNames()));
        for (Line line: ladder.getLines()) {
            sb.append(DrawLine.drawLine(line));
        }
        return sb.toString();
    }

    private static String formatName(String name) {
        StringBuilder sb = new StringBuilder();
        int spaceLength = 6 - name.length();
        sb.append(" ".repeat(Math.max(0, spaceLength / 2)));
        sb.append(name);
        sb.append(" ".repeat(Math.max(0, spaceLength - spaceLength / 2)));
        return sb.toString();
    }

    private static String formatNames(List<String> peopleNames) {
        StringBuilder sb = new StringBuilder();
        for(String name: peopleNames) {
            sb.append(formatName(name));
        }
        sb.append('\n');
        return sb.toString();
    }
}
