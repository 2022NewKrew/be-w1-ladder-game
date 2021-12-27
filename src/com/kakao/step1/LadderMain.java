package com.kakao.step1;

import java.util.InputMismatchException;

public class LadderMain {
    public static void main(String[] args) {
        Ladder ladder = null;
        try {
            ladder = new Ladder(Ladder.initInput());
        } catch (InputMismatchException e) {
            System.out.println("값이 잘못 되었습니다. 다시 시작해 주시기 바랍니다.");
            return;
        }

        ladder.printLadder();
    }
}