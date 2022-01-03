package controller;

import service.GameResultService;
import service.LadderService;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {

    private static LadderGame INSTANCE;
    private final LadderService ladderService;
    private final GameResultService gameResultService;


    private LadderGame() {
        this.ladderService = new LadderService();
        this.gameResultService = new GameResultService();
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public void run() {
        List<String> users = UserInput.getUserList();
        List<String> results = UserInput.getLadderResult();
        ladderService.generateLadder(users.size() - 1, UserInput.getLadderHeight());
        gameResultService.calculateGameResult(ladderService.getLadderDto(), users, results);
        printLadder(users, results);
        String target = "";
        while (!target.equals("춘식이")) {
            target = UserInput.getTarget();
            printGameResult(target);
        }
    }

    private void printLadder(List<String> users, List<String> results) {
        UserOutput.printLadderToConsole(ladderService.getLadderDto(), users, results);
    }

    private void printGameResult(String target) {
        if (target.equals("춘식이")) {
            return;
        }
        if (target.equals("all")) {
            UserOutput.printAllResult(gameResultService.getAllResult());
            return;
        }
        UserOutput.printTargetResult(gameResultService.getTargetResult(target));
    }

}
