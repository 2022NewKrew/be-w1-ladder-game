package com.kakao.view;

import com.kakao.domain.ladder.Ladder;
import com.kakao.domain.ladder.LadderPrinter;
import com.kakao.domain.player.Player;
import java.util.List;

public class OutputView {

    private final LadderPrinter ladderPrinter;

    public OutputView() {
        ladderPrinter = new LadderPrinter();
    }

    public void print(List<Player> players, Ladder ladder) {
        System.out.println("실행결과\n");
        System.out.println(ladderPrinter.generatePlayerNames(players));
        System.out.println(ladderPrinter.generateLadder(ladder));
    }
}
