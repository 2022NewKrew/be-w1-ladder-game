package ladder.domain;

import java.util.ArrayList;

public class Ladder {
    //상수 및 클래스 변수

    //인스턴스 변수
    private final ArrayList<String> peopleNames;
    private final ArrayList<Line> lines;

    //생성자
    public Ladder(ArrayList<String> peopleNames, int ladderSize) {
        this.peopleNames = peopleNames;
        lines = new ArrayList<>();
        for(int i = 0; i < ladderSize; i++) {
            lines.add(new Line(peopleNames.size()));
        }
    }

    //메서드
    public ArrayList<String> getPeopleNames() {
        return this.peopleNames;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
}
