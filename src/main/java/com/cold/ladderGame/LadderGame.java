package com.cold.ladderGame;

import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        ladder.setValues();
        ladder.createLadder();
        ladder.printladder();
    }
}
