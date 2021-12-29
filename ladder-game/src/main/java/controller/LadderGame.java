package controller;

import domain.ladder.Ladder;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {

    public static LadderGame INSTANCE;

    private final List<String> userList;
    private final Ladder ladder;

    private LadderGame() {
        userList = UserInput.getUserList();
        ladder = new Ladder(userList.size(), UserInput.getLadderHeight());
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladder, userList);
    }

}
