package com.kakaocorp.laddergame;

import com.kakaocorp.laddergame.ladder.Ladder;
import com.kakaocorp.laddergame.ladder.NameLadder;
import com.kakaocorp.laddergame.ladder.SimpleLadder;

public class LadderGame {

    public static void main(String[] args) {
        // SimpleLadder 게임(1~2단계 구현)
//        Ladder ladder = new SimpleLadder();

        // NameLadder 게임(3단계 구현)
        Ladder ladder = new NameLadder();

        if (!ladder.start()) {
            return;
        }
        ladder.makeLadder();
        ladder.printLadder();
    }

}
