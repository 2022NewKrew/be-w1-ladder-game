package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.view.LadderView;

import java.util.List;

public class LadderGame {

    public static void play() {
        LadderView ladderView = new LadderView();

        List<Player> players = ladderView.inputPlayers();
        int maxLadderHeight = ladderView.inputMaxLadderHeight();

        Ladder ladder = new Ladder(players, maxLadderHeight);

        ladderView.printLadder(players, ladder);
    }
}
