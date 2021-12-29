package org.cs.finn.laddergame;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.view.LadderView;
import org.cs.finn.laddergame.view.UserInput;

public class LadderGame {
    private final UserInput userInput = new UserInput();
    private final LadderView ladderView = new LadderView();
    private final Ladder ladder = new Ladder();

    public LadderGame() {
        System.out.println("--- 사다리 게임 ---");
    }

    public void run() {
        requestInput();
        createLadder();
        printLadder();
        closeGame();
    }

    private void requestInput() {
        userInput.requestInput();
    }

    private void createLadder() {
        ladder.build(userInput.getInput());
    }

    private void printLadder() {
        ladderView.print(ladder);
    }

    private void closeGame() {
        userInput.closeScanner();
    }
}
