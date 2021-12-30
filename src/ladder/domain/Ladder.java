package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    //상수 및 클래스 변수

    //인스턴스 변수
    private final ArrayList<String> peopleNames;
    private final ArrayList<Line> ladder;

    //생성자
    public Ladder(ArrayList<String> peopleNames, int ladderSize) {
        this.peopleNames = peopleNames;
        ladder = new ArrayList<>();
        for(int i = 0; i < ladderSize; i++) {
            ladder.add(new Line(peopleNames.size()));
        }
    }

    //메서드
    private String formatName(String name) {
        StringBuilder sb = new StringBuilder();
        int spaceLength = 6 - name.length();
        sb.append(" ".repeat(Math.max(0, spaceLength / 2)));
        sb.append(name);
        sb.append(" ".repeat(Math.max(0, spaceLength - spaceLength / 2)));
        return sb.toString();
    }

    private String formatNames() {
        StringBuilder sb = new StringBuilder();
        for(String name: peopleNames) {
            sb.append(formatName(name));
        }
        sb.append('\n');
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(formatNames());
        for (Line line: ladder) {
            sb.append(line);
        }
        return sb.toString();
    }
}
