package com.kakao.ladder.step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private int height;
    private List<String> peoples;
    private List<String> inputResult;
    private List<String> results = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();

    // 사람, 높이를 주지 않으면 자동으로 설정해준다.
    public Ladder() {
        this(Arrays.asList("A", "B"), Arrays.asList("꽝", "당첨"), 5);
    }

    // 사람, 높이를 주었을 때 그에 맞게 초기화해준다. 자동으로 사다리를 만든다.
    public Ladder(List<String> peoples, List<String> resultList, int height) {
        this.peoples = peoples;
        this.height = height;
        this.inputResult = resultList;
        makeLadder();
        makeAllResult();
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
    private Line makeLine() {
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

    // 재귀문을 돌며 각 사람마다 결과를 출력해준다. location은 높이, index는 위치.
    // index의 왼쪽, 오른쪽에 bridge 여부를 확인해가며 사다리를 타고 내려간다.
    private String makeResult(int location, int index) {
        if(location == height)
            return inputResult.get(index);
        Line line;
        line = lines.get(location);
        if(line.getBridge(index - 1))
            return makeResult(location + 1, index - 1);
        if(line.getBridge(index))
            return makeResult(location + 1, index + 1);
        return makeResult(location + 1, index);
    }

    // 모든 결과를 만들어준다.
    private void makeAllResult() {
        for(int i = 0; i < peoples.size(); i++) {
            results.add(makeResult(0, i));
        }
    }

    // printLadder에 전달하기 위한 getter들

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getPeoples() {
        return peoples;
    }

    public List<String> getResults() {
        return results;
    }

    public List<String> getInputResult() {
        return inputResult;
    }

}