package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {
    private static ArrayList<String> names;
    private static ArrayList<String> ladderResults;
    private static int height;
    private static Ladder ladder;
    private static final HashMap<String, String> playerResults = new HashMap<String, String>();
    private static final String END_COMMAND = "춘식이";
    private static final String SHOW_ALL_RESULT_COMMAND = "all";

    private static void inputInfo() {
        names = InputView.inputName();
        Validation.validateNames(names);
        ladderResults = InputView.inputLadderResult();
        Validation.validateLadderResults(ladderResults, names.size());
        height = InputView.inputHeight();
        Validation.validateHeight(height);
    }

    private static void buildLadder() {
        LadderBuilder ladderBuilder = new LadderBuilder(names.size(), height);
        ladder = ladderBuilder.makeLadder();
    }

    private static void viewLadderGameResult() {
        ResultView.printGameResultMessage();
        ResultView.printNameOrResult(names);
        ResultView.printLadder(ladder.getLadder());
        ResultView.printNameOrResult(ladderResults);
    }

    private static void playerLadder() {
        for (int i = 0; i < names.size(); i++) {
            int resultIndex = ladder.play(i);
            playerResults.put(names.get(i), ladderResults.get(resultIndex));
        }
    }

    private static Boolean isGameEnd(String command) {
        if (command.equals(END_COMMAND)) {
            ResultView.printEndGameMessage();
            return true;
        }
        return false;
    }

    private static void viewPlayerResult(String command) {
        if (command.equals(SHOW_ALL_RESULT_COMMAND)) {
            ResultView.printPlayerResults(playerResults);
            return;
        }
        Validation.validateName(command, playerResults);
        ResultView.printPlayerResult(playerResults.get(command));
    }

    private static void inputPlayerCommand() {
        String command = InputView.inputCommand();

        while (!isGameEnd(command)) {
            viewPlayerResult(command);
            command = InputView.inputCommand();
        }
    }

    public static void startGame() {
        inputInfo();
        buildLadder();
        viewLadderGameResult();
        playerLadder();
        inputPlayerCommand();
    }
}
