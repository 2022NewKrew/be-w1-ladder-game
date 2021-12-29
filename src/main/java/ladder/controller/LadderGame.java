package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.LadderView;

public class LadderGame {

    public static void play() {
        LadderView ladderView = new LadderView();

        int numberOfPlayers = ladderView.inputNumberOfPlayers();
        int maxLadderHeight = ladderView.inputMaxLadderHeight();

        Ladder ladder = new Ladder(numberOfPlayers, maxLadderHeight);
        ladder.createLadder();

        ladderView.printLadder(ladder);
    }
}
