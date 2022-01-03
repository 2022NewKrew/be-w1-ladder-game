package ladder;

import java.util.Map;
import ladder.dto.InfoDto;
import ladder.dto.PlayerDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    private static final String ALL = "all";
    private static final String CHUNSHIK = "춘식이";

    public static void main(String[] args) {
        final LadderController ladderController = getLadderController();
        final InfoDto infoDto = ladderController.info();
        OutputView.printLadderInfo(infoDto);

        final Map<PlayerDto, String> results = ladderController.foundResult();

        String userInput;
        do {
            userInput = InputView.inputRewardPlayerName();
            printResult(userInput, results, ladderController);
        } while (isEnd(userInput));
    }

    private static void printResult(String userInput, Map<PlayerDto, String> results,
        LadderController ladderController) {
        if (ALL.equalsIgnoreCase(userInput)) {
            OutputView.printResultAll(results);
            return;
        }
        if (CHUNSHIK.equals(userInput)) {
            return;
        }
        printSingleResult(userInput, results, ladderController);
    }

    private static void printSingleResult(String userInput, Map<PlayerDto, String> results,
        LadderController ladderController) {
        try {
            PlayerDto playerDto = ladderController.findPlayer(userInput);
            OutputView.printResult(results.get(playerDto));
        } catch (Exception e) {
            OutputView.printBadInput();
        }
    }

    private static boolean isEnd(String userInput) {
        return !CHUNSHIK.equals(userInput);
    }

    private static LadderController getLadderController() {
        final String[] players = InputView.inputPlayers();
        final String[] rewards = InputView.inputReward();
        final int ladderHeight = InputView.inputLadderHeight();

        return new LadderController(players, rewards, ladderHeight);
    }
}
