package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladder {
    ArrayList<Line> ladder;
    // width, height의 경우 이미 Ladder 인스턴스에 속해있어 ladder 생략
    int peopleCount, width, height;
    ArrayList<String> names;

    StringBuilder sb;

    public Ladder(int peopleCount, int height, String namesString) {
        this.peopleCount = peopleCount;
        this.width = peopleCount - 1;
        this.height = height;
        this.ladder = new ArrayList<Line>();
        this.names = new ArrayList<String>(Arrays.asList(namesString.split(",")));
        sb = new StringBuilder();
    }

    public void makeLadder() {
        for (int i = 0; i < height; i++) {
            Line line = new Line(width);
            line.makeLine();
            ladder.add(line);
        }
    }

    public String toString() {
        sb.setLength(0);
        writeNames();
        writeLadder();
        return sb.toString();
    }

    private void writeLadder() {
        for (int i = 0; i < height; i++) {
            String lineString = ladder.get(i).toString();
            sb.append(lineString);
        }
    }

    public void writeNames() {
        int revealNameLength;
        String revealName;
        for (String name : names) {
            revealNameLength = name.length() > 5 ? 5 : name.length();
            revealName = name.substring(0, revealNameLength);
            sb.append(" ".repeat(LadderConstant.INTERVAL / 2 - revealNameLength / 2));
            sb.append(revealName);
            sb.append(" ".repeat((LadderConstant.INTERVAL - LadderConstant.INTERVAL / 2) - (revealNameLength - revealNameLength / 2) + 1));
        }
        sb.append("\n");
    }

    public String getCurrentString() {
        return sb.toString();
    }
}
