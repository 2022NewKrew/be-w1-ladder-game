package controller;

import domain.ladder.Ladder;
import service.LadderGameService;
import view.UserInput;
import view.UserOutput;

import java.util.List;
import java.util.stream.Stream;

public class LadderGame {
    private static final int MAX_LENGTH = 5;
    private static LadderGame INSTANCE;

    private final List<String> users;
    private final Ladder ladder;
    private final List<String> results;
    private final LadderGameService ladderGameService;

    private LadderGame() {
        List<String> users = UserInput.getUserList();
        LadderGamePrecondition.checkUsers(users, MAX_LENGTH);
        List<String> results = UserInput.getLadderResult();
        LadderGamePrecondition.checkResults(results, MAX_LENGTH, users.size());
        this.users = users;
        this.ladder = new Ladder(this.users.size(), UserInput.getLadderHeight());
        this.results = results;
        this.ladderGameService = new LadderGameService(users, results);
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public void run() {

        ladderGameService.calculateResult(ladder);
        String target = null;
        while (target != "춘식이") {
            target = UserInput.getTarget();
            printResult(ladderGameService.getResult(target));
        }
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladder, users, results);
    }

    public void printResult(String target) {
        if (target == "춘식이") {
            return;
        }
        if (target == "all") {
            UserOutput.printAllResult();
            return;
        }
        UserOutput.printTargetResult(target);
    }

}
