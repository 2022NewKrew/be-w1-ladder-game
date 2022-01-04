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

    public static void run() {
        List<String> users = UserInput.getUserList();
        List<String> results = UserInput.getLadderResult();
        Ladder ladder = new Ladder(users.size() - 1, UserInput.getLadderHeight());
        printLadder(users, results, ladder);
        showGameResult(ladder.getGameResult(users, results));
    }

    private static void printLadder(List<String> users, List<String> results, Ladder ladder) {
        UserOutput.printLadderToConsole(LadderDTO.getLadderDTO(ladder), users, results);
    }

    private static void showGameResult(GameResult gameResult) {
        String keyWord = UserInput.getTarget();
        while (isContinue(keyWord)) {
            printGameResult(gameResult, keyWord);
            keyWord = UserInput.getTarget();
        }
    }

    private static void printGameResult(GameResult gameResult, String keyWord) {
        if (keyWord.equals("all")) {
            UserOutput.printAllResult(AllResultDTO.getAllResultDTO(gameResult));
            return;
        }
        UserOutput.printTargetResult(TargetResultDTO.getTargetResultDTO(gameResult, keyWord));
    }

    private static boolean isContinue(String target) {
        return !target.equals("춘식이");
    }

}
