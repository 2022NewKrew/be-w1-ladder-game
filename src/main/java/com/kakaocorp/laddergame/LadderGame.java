package com.kakaocorp.laddergame;

import com.kakaocorp.laddergame.ladder.domain.NameLadder;
import com.kakaocorp.laddergame.ladder.view.LadderView;

public class LadderGame {

    public static void main(String[] args) {
        NameLadder ladder = new NameLadder();

        if (!ladder.start()) {
            System.out.println("게임이 제대로 진행되지 않았습니다.");
            return;
        }
        ladder.makeLines();

        LadderView ladderView = new LadderView(ladder);
        ladderView.memberPrint();
        ladderView.ladderPrint();
        ladderView.resultPrint();
    }

}
