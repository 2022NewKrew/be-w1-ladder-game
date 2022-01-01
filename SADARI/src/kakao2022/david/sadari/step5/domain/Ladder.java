package kakao2022.david.sadari.step5.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ladder {
    private final List<String> peopleList;
    private final int countOfPerson;
    private final int ladderHeight;
    private final List<Line> ladderBoard = new ArrayList<>();
    private final List<String> resultList;

    public Ladder(List<String> peopleList, int ladderHeight, List<String> resultList) {
        this.peopleList = peopleList;
        countOfPerson = peopleList.size();
        this.ladderHeight = ladderHeight;
        this.resultList = resultList;
        makeLine();
    }

    private void makeLine() {
        for (int i = 0; i < ladderHeight; i++) {
            Line line = new Line(countOfPerson);
            ladderBoard.add(line);
        }
    }

    public HashMap<String, String> getGameResult() {
        HashMap<String, String> gameResult = new HashMap<>();
        for (String person : peopleList) {
            gameResult.put(person, getLadderResult(person));
        }
        return gameResult;
    }

    private String getLadderResult(String person) {
        int position = peopleList.indexOf(person);
        for (int curHeight = 0; curHeight < ladderHeight; curHeight++) {
            position = getNextPosition(position, curHeight);
        }
        return resultList.get(position);
    }

    private int getNextPosition(int position, int curHeight) {
        Line line = ladderBoard.get(curHeight);
        if (line.isLine(position - 1)) {
            return position - 1;
        }
        if (line.isLine(position)) {
            return position + 1;
        }
        return position;
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
        ladderInfo.append("\n");
        for (String result : resultList) {
            ladderInfo.append(String.format("%-6s", result));
        }
        return ladderInfo;
    }
}
