package controller;

import dao.LadderDAO;
import domain.gameResult.GameResultPrecondition;
import domain.ladder.Ladder;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {

    private static LadderGame INSTANCE;
    private final List<String> users;
    private final Ladder ladder;


    private LadderGame() {
        List<String> users = UserInput.getUserList();
        this.users = users;
        this.ladder = new Ladder(this.users.size(), UserInput.getLadderHeight());
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladder, users);
    }

}
