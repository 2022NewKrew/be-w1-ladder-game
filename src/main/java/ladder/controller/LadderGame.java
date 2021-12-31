package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import ladder.domain.Player;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.*;

public class LadderGame {

    private static final int MAX_USER_NAME_LENGTH = 5;
    private static final String GAME_END_MESSAGE = "춘식이";

    private static InputView inputView;
    private static OutputView outputView;

    public static void play() {
        inputView = new InputView(MAX_USER_NAME_LENGTH);
        outputView = new OutputView(MAX_USER_NAME_LENGTH);
        List<Player> players = inputView.inputPlayers();
        List<Result> results = inputView.inputResults();
        int maxLadderHeight = inputView.inputMaxLadderHeight();
        Ladder ladder = new Ladder(players, maxLadderHeight);

        outputView.printLadder(players, results, ladder);
        loopGameResultInput(playGame(players, results, ladder));
    }

    private static Map<String, String> playGame(List<Player> players, List<Result> results, Ladder ladder) {
        Map<String, String> resultMap = new HashMap<>();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Result result = results.get(getPlayerGameResult(i, ladder));

            resultMap.put(player.getName(), result.getResult());
        }
        return resultMap;
    }

    private static int getPlayerGameResult(int startLine, Ladder ladder) {
        int currentLine = startLine;

        for (int j = 0; j < ladder.getMaxLadderHeight(); j++) {
            LadderRow ladderRow = ladder.getLadderRow(j);
            currentLine = ladderRow.getNextLineNumber(currentLine);
        }
        return currentLine;
    }

    private static void loopGameResultInput(Map<String, String> resultMap) {
        String playerName = "";

        while (!playerName.equals(GAME_END_MESSAGE)) {
            playerName = inputView.inputResultPlayer();
            outputView.printResult(playerName, resultMap);
        }
        outputView.printGameEnd();
    }
}
