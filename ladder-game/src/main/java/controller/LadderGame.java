package controller;

import domain.ladder.Ladder;
import view.UserInput;
import view.UserOutput;

public class LadderGame {

    public static LadderGame INSTANCE;

    private final Ladder ladder;

    private LadderGame(int numberOfPeople, int ladderHeight) {
        ladder = new Ladder(numberOfPeople, ladderHeight);
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame(UserInput.getNumberOfPeople(), UserInput.getLadderHeight());
        }
        return INSTANCE;
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladder);
    }

}
