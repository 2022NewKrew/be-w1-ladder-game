package main.java.controller;

import main.java.domain.*;
import main.java.view.InputView;
import main.java.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderController {
    private Players players;
    private ExecutionResults executionResults;
    private Ladder ladder;
    private LadderResults ladderResults;
    private static final String ALL_PLAYERS = "all";

    public LadderController() {
        players = new Players(InputView.enterPlayers());
        executionResults = new ExecutionResults(players.numberOfPlayer(), InputView.enterExecutionResults());
        LadderGenerator ladderGenerator = new LadderGenerator();
        ladder = ladderGenerator.generateLadder(players.numberOfPlayer(), InputView.enterHeight());
    }

    public void run() {
        printPlayers();
        printLadder();
        printResult();
        ladderResults = ladder.ladderResults(players, executionResults);
        printExecutionResult();
        printExecutionResult();
        printExecutionResult();
    }

    private void printPlayers() {
        List<String> playersList = players.players()
                .stream()
                .map(player -> player.name())
                .collect(Collectors.toList());
        ResultView.printPlayers(playersList);
    }

    private void printLadder() {
        ResultView.printLadder(ladder);
    }

    private void printResult() {
        ResultView.printResult(executionResults.executionResults());
    }

    private void printExecutionResult() {
        String playerName = InputView.enterPlayerYouWant();
        Map<String, String> results;
        if (playerName.equalsIgnoreCase(ALL_PLAYERS)) {
            results = ladderResults.resultsOfAll();
            ResultView.printExecutionResult(results);
            return;
        }
        results = ladderResults.results(new Player(playerName));
        ResultView.printExecutionResult(results);
    }
}
