package main.java.controller;

import main.java.domain.Ladder;
import main.java.domain.LadderGenerator;
import main.java.domain.Players;
import main.java.view.InputView;
import main.java.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private Players players;
    private Ladder ladder;

    public LadderController() {
        players = new Players(InputView.enterPlayers());
        LadderGenerator ladderGenerator = new LadderGenerator();
        ladder = ladderGenerator.generateLadder(players.numberOfPlayer(), InputView.enterHeight());
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

    public void run() {
        printPlayers();
        printLadder();
    }
}
