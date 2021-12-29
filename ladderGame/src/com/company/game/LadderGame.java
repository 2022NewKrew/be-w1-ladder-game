package com.company.game;

import com.company.ladder.Ladder;

import java.util.ArrayList;
import java.util.Scanner;

public class LadderGame {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> attendants;
    int ladderHeight;
    Ladder ladder;

    public LadderGame(){
        attendants = new ArrayList<String>();
        ladderHeight = 0;
    }

    public void start(){
        initialize();

        printName();
        ladder.printLadder();
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
