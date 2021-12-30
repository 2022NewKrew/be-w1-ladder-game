package ladder.view;

import ladder.domain.Line;

import java.util.ArrayList;

public class DrawLine {
    public static String drawLine(Line line) {
        ArrayList<Boolean> points = line.getPoints();
        StringBuilder sb = new StringBuilder();
        sb.append("  |");
        for (Boolean e : points) {
            sb.append(e ? "     |" : "-----|");
        }
        sb.append('\n');
        return sb.toString();
    }
}
