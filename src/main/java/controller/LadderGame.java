package controller;

<<<<<<< HEAD
import dao.LadderDAO;
import domain.gameResult.GameResultPrecondition;
import domain.ladder.Ladder;
import dto.LadderDTO;
=======
>>>>>>> ae03577 (5단계 구현 완료)
import service.LadderGameService;
import service.LadderService;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {

    private static LadderGame INSTANCE;
    private final List<String> users;
    private final List<String> results;
    private final LadderService ladderService;
    private final LadderGameService ladderGameService;


    private LadderGame() {
        List<String> users = UserInput.getUserList();
        this.users = users;
        this.ladderDAO = new LadderDAO();
        this.results = results;
        this.ladderService = new LadderService(this.users.size(), UserInput.getLadderHeight());
        this.ladderGameService = new LadderGameService(users, results);
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public void run() {
        ladderGameService.calculateGameResult(ladderService.getLadderDto());
        String target = "";
        while (!target.equals("춘식이")) {
            target = UserInput.getTarget();
            printGameResult(target);
        }
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladderService.getLadderDto(), users, results);
    }

}
