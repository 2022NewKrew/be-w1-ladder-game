package com.kakaocorp.laddergame;

import com.kakaocorp.laddergame.ladder.Ladder;
import com.kakaocorp.laddergame.ladder.SimpleLadder;

import java.util.*;

public class LadderGame {

    public static void main(String[] args) {
        Ladder ladder = new SimpleLadder();

        ladder.start();
        ladder.makeLadder();
        ladder.printLadder();
    }

}
