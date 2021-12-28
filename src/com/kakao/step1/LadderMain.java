package com.kakao.step1;

import java.util.InputMismatchException;

public class LadderMain {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(new UserInput());

        ladder.printLadder();
    }
}