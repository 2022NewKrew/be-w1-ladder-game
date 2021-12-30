package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Line {
    int width;
    ArrayList<Boolean> point;
    StringBuilder sb;

    public Line(int width) {
        this.width = width;
        sb = new StringBuilder();
        point = new ArrayList<Boolean>();
    }

    public String toString() {
        sb.setLength(0);
        sb.append(" ".repeat(LadderConstant.INTERVAL / 2));
        for (int j = 0; j < width; j++) {
            sb.append(makeVerticals());
            sb.append(makeHorizons(point.get(j)));
        }
        sb.append(makeVerticals());
        sb.append("\n");

        return sb.toString();
    }

    private String makeHorizons(Boolean isExist) {
        return isExist ? "-".repeat(LadderConstant.INTERVAL) : " ".repeat(LadderConstant.INTERVAL);
    }

    private String makeVerticals() {
        return "|";
    }

    public void makeLine() {
        for (int i = 0; i < width; i++)
            point.add(checkPreviousPoint(i));
    }

    public Boolean checkPreviousPoint(int index) {
        if (index < 0 || index >= width)
            return false;
        return (!(index != 0) || !point.get(index - 1)) && Math.random() > 0.5;
    }

    public void setPoint(Boolean[] pointArray) {
        point.clear();
        Collections.addAll(point, pointArray);
    }
}
