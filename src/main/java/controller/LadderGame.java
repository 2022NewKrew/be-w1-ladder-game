package controller;

import domain.gameResult.GameResult;
import domain.ladder.Ladder;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;
import dto.ladderDto.LadderDTO;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {

    private static LadderGame INSTANCE;

    private GameResult gameResult;
    private Ladder ladder;

    private LadderGame() {
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
        generateLadder(users.size() - 1, UserInput.getLadderHeight());
        generateGameResult(users, results);
        printLadder(users, results);
        showGameResult();
    }

    public void generateLadder(int frameLength, int ladderHeight) {
        ladder = new Ladder(frameLength, ladderHeight);
    }

    public void generateGameResult(List<String> users, List<String> results) {
        gameResult = ladder.getGameResult(users, results);
    }

    private void printLadder(List<String> users, List<String> results) {
        UserOutput.printLadderToConsole(LadderDTO.getLadderDTO(ladder), users, results);
    }

    private void showGameResult() {
        String target = UserInput.getTarget();
        while (isContinue(target)) {
            printGameResult(target);
            target = UserInput.getTarget();
        }
    }

    private void printGameResult(String target) {
        if (target.equals("all")) {
            UserOutput.printAllResult(AllResultDTO.getAllResultDTO(gameResult));
            return;
        }
        UserOutput.printTargetResult(TargetResultDTO.getTargetResultDTO(gameResult, target));
    }

    private boolean isContinue(String target) {
        return !target.equals("춘식이");
    }

}
