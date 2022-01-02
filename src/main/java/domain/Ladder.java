package main.java.domain;

import java.util.ArrayList;
import java.util.List;

import static main.java.util.Util.centerString;

public class Ladder implements Print {
    private final int MAX_LENGTH = 6;
    private final int MOVE_LEFT = -1;
    private final int MOVE_RIGHT = 1;
    private final int MOVE_DOWN = 0;

    // instance variable
    private List<String> peopleNameList;
    private List<String> resultList;
    private int ladderHeight;
    private List<Line> lines;

    // Constructor
    public Ladder(List<String> peopleNameList, List<String> resultList, int ladderHeight) {
        this.peopleNameList = peopleNameList;
        this.resultList = resultList;
        this.ladderHeight = ladderHeight;
        this.lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            addLadderLine(Line.create(peopleNameList.size()));
        }
    }

    private void addLadderLine(Line ladderLine) {
        this.lines.add(ladderLine);
    }

    public String findNameByOrder(int order) {
        return this.peopleNameList.get(order);
    }

    public int findOrderByName(String name) {
        return this.peopleNameList.indexOf(name);
    }

    public String findResultByOrder(int nameOrder) {
        int curOrder = nameOrder;
        for (int i = 0; i < this.ladderHeight; i++) {
            Line curLine = this.lines.get(i);
            Point curPoint = curLine.getPoint(curOrder);
            curOrder += nextPoint(curPoint);
        }
        return this.resultList.get(curOrder);
    }

    private int nextPoint(Point curPoint) {
        if (curPoint.isInLeftBridge()) {
            return MOVE_LEFT;
        } else if (curPoint.isInRightBridge()) {
            return MOVE_RIGHT;
        }
        return MOVE_DOWN;
    }

    public int getSize() {
        return this.peopleNameList.size();
    }


    public void print() {
        StringBuilder ladderInfo = new StringBuilder();

        // 참가자 이름 출력
        for (String name : this.peopleNameList) {
            ladderInfo.append(centerString(this.MAX_LENGTH, name));
        }
        ladderInfo.append("\n");

        // 사다리 라인 출력
        for (int i = 0; i < lines.size(); i++) {
            ladderInfo.append("  " + lines.get(i).toString() + "\n");
        }

        // 실행 결과 출력
        for (String result : this.resultList) {
            ladderInfo.append(centerString(this.MAX_LENGTH, result));
        }
        ladderInfo.append("\n");
        System.out.println(ladderInfo);
    }
}