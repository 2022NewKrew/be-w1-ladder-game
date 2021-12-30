package ladder;

import java.util.Map;
import java.util.Objects;
import ladder.dto.InfoDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    private static final String ALL = "all";
    private static final String CHUNSHIK = "춘식이";

    public static void main(String[] args) {
        final LadderController ladderController = getLadderController();
        final InfoDto infoDto = ladderController.info();
        OutputView.printLadderInfo(infoDto);

        final Map<String, String> results = ladderController.foundResult();

        String userInput = "";
        do {
            userInput = InputView.inputRewardPlayerName();
            printResult(userInput, results);
        } while (isEnd(userInput));
    }

    private static void printResult(String userInput,Map<String, String> results) {
        if (ALL.equalsIgnoreCase(userInput)) {
            OutputView.printResultAll(results);
            return;
        }
        if (CHUNSHIK.equals(userInput)) {
            return;
        }
        printSingleResult(userInput, results);
    }

    private static void printSingleResult(String userInput, Map<String, String> results) {
        try {
            String reward = results.get(userInput);
            validate(reward);
            OutputView.printResult(reward);
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

    private static void validate(String reward) {
        if (Objects.isNull(reward)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
    }
}
