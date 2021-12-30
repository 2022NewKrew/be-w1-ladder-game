package controller;

import dao.LadderDAO;
import domain.gameResult.GameResultPrecondition;
import domain.ladder.Ladder;
import dto.LadderDTO;
import service.LadderGameService;
import view.UserInput;
import view.UserOutput;

import java.util.List;
import java.util.stream.Stream;

public class LadderGame {

    private static LadderGame INSTANCE;
    private final List<String> users;
    private final LadderDAO ladderDAO;
    private final List<String> results;
    private final LadderGameService ladderGameService;


    private LadderGame() {
        List<String> users = UserInput.getUserList();
        this.users = users;
        this.ladderDAO = new LadderDAO();
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

        ladderGameService.calculateResult(ladderDAO.getLadderDTO());
        String target = "";
        while (!target.equals("춘식이")) {
            target = UserInput.getTarget();
            printResult(target);
        }
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladderDAO.getLadderDTO(), users, results);
    }

}
