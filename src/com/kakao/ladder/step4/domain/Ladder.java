package com.kakao.ladder.step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private int height;
    private List<String> peoples;
    private List<Line> lines = new ArrayList<>();

    // 사람, 높이를 주지 않으면 자동으로 설정해준다.
    public Ladder() {
        this(Arrays.asList("A", "B"), 5);
    }

    // 사람, 높이를 주었을 때 그에 맞게 초기화해준다. 자동으로 사다리를 만든다.
    public Ladder(List<String> peoples, int height) {
        this.peoples = peoples;
        this.height = height;
        makeLadder();
    }

    // bridge를 line에 추가해주고 bridge를 만들었다면 그 다음번엔 bridge를 만들지 못하므로 false를 return해준다.
    private boolean makeBridge(boolean canMake, Line line) {
        if(canMake) {
            line.addLine(true);
            return false;
        }
        line.addLine(false);
        return true;
    }

    // canMake가 false인 경우 bridge를 만들지 않고 종료하고 그렇지 않은 경우 랜덤하게 bridge를 만들어준다.
    private boolean makeRandomBridge(boolean canMake, Line line) {
        if(!canMake) {
            return makeBridge(false, line);
        }
        double randNum;
        randNum = Math.random();
        if(randNum >= 0.5) {
            return makeBridge(false, line);
        }
        return makeBridge(true, line);
    }

    // 현재 bridge를 만들수 있는 경우 canMake 값이 true이다. 초기에 가장 왼쪽 bridge는 항상 만들수 있으므로 true로 초기화한다.
    protected Line makeLine() {
        boolean canMake = true;
        Line line = new Line();
        for(int i = 1; i < peoples.size(); i++) {
            canMake = makeRandomBridge(canMake, line);
        }
        return line;
    }

    // 사다리를 만들어준다.
    private void makeLadder() {
        for(int i = 0; i < height; i++) {
            lines.add(makeLine());
        }
    }

    // printLadder에 전달하기 위한 getter들

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getPeoples() {
        return peoples;
    }

}