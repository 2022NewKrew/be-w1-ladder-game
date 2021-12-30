package com.kakao.ladder.step3.view;

import com.kakao.ladder.step3.domain.Ladder;
import com.kakao.ladder.step3.domain.Line;

import java.util.List;
import java.util.Scanner;

public class LadderPrinter {

    private List<Line> lines;
    private List<String> peoples;
    private List<String> results;
    private List<String> resultList;

    public LadderPrinter(Ladder ladder){
        this.lines = ladder.getLines();
        this.peoples = ladder.getPeoples();
        this.results = ladder.getResults();
        this.resultList = ladder.getResultList();
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

    private void printEachResult(String result) {
        System.out.printf("%-6.5s", result);
    }

    // 결과 리스트를 출력한다.
    private void printResultList() {
        for(String result : resultList) {
            printEachResult(result);
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
        printResultList();
    }

    private boolean printAll() {
        for(int i = 0; i < peoples.size(); i++) {
            System.out.println(peoples.get(i) + " : " + results.get(i));
        }
        return true;
    }

    private boolean falseName() {
        System.out.println("잘못된 이름입니다");
        return true;
    }

    private boolean exitGame() {
        System.out.println("게임을 종료합니다.");
        return false;
    }

    private boolean printResult(String people) {
        if(people.equals("춘식이"))
            return exitGame();
        System.out.println("\n실행 결과");
        if(people.equals("all"))
            return printAll();
        int peopleIndex = peoples.indexOf(people);
        if(peopleIndex < 0)
            return falseName();
        System.out.println(results.get(peopleIndex));
        return true;
    }

    public void printResults() {
        Scanner s = new Scanner(System.in);
        String people;
        boolean doMore = true;
        while(doMore) {
            System.out.println("\n결과를 보고 싶은 사람은?");
            people = s.nextLine();
            doMore = printResult(people);
        }
    }

}
