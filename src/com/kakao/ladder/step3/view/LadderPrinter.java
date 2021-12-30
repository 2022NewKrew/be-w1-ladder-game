package com.kakao.ladder.step3.view;

import com.kakao.ladder.step3.domain.Ladder;
import com.kakao.ladder.step3.domain.Line;

import java.util.List;

public class LadderPrinter {

    private List<Line> lines;
    private List<String> peoples;

    public LadderPrinter(Ladder ladder){
        this.lines = ladder.getLines();
        this.peoples = ladder.getPeoples();
    };

    // 이름이 5자 이상인 경우 앞의 5자까지만 추가해준다. 길이에 맞춰서 다음 사람의 이름까지 적절한 공백을 준다.
    protected void printPeople(String people) {
        System.out.printf("%-6.5s", people);
    }

    // 사람 리스트를 출력한다.
    private void printPeoples() {
        for(String people : peoples) {
            printPeople(people);
        }
        System.out.println();
    }

    //전체 사다리를 출력한다.
    public void printLadder() {
        System.out.println("사다리 결과\n");
        printPeoples();
        for(Line line : lines) {
            System.out.println(line.toString());
        }
    }
}
