package com.company.game;

import com.company.ladder.Ladder;
import com.company.view.ConsoleView;
import com.company.view.PrintInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class LadderGame {
    static final Scanner scanner = new Scanner(System.in);
    PrintInterface printInterface;
    ArrayList<String> attendants;
    int ladderHeight;
    Ladder ladder;

    public LadderGame(){
        attendants = new ArrayList<String>();
        printInterface = new ConsoleView();
        ladderHeight = 0;
    }

    public void start(){
        initialize();
        printName();
        ladder.printLadder(printInterface);
    }


    private void initialize(){
        getAttendantsNames();
        getLadderHeight();

        ladder = new Ladder(attendants.size(), ladderHeight);
        ladder.makeLadder();
    }

    private void getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
    }

    private void getAttendantsNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();

        for (String name : names.split(",")) {
            attendants.add(name);
        }
    }

    private void printName() {
        for (String name : attendants) {
            System.out.printf(name + " ");
        }
        System.out.println();
    }
}
