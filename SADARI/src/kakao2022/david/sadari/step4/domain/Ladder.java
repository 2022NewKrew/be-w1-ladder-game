package kakao2022.david.sadari.step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<String> peopleList;
    private final int countOfPerson;
    private final int ladderHeight;
    private final List<Line> ladderBoard = new ArrayList<>();

    public Ladder(List<String> peopleList, int ladderHeight) {
        this.peopleList = peopleList;
        countOfPerson = peopleList.size();
        this.ladderHeight = ladderHeight;
        makeLine();
    }

    private void makeLine() {
        for (int i = 0; i < ladderHeight; i++) {
            Line line = new Line(countOfPerson);
            ladderBoard.add(line);
        }
    }

    public StringBuilder getLadderInfo() {
        StringBuilder ladderInfo = new StringBuilder();
        for (String person : peopleList) {
            ladderInfo.append(String.format("%-6s", person));
        }
        for (Line line : ladderBoard) {
            ladderInfo.append("\n");
            ladderInfo.append(line.getLineInfo());
        }
        return ladderInfo;
    }
}
