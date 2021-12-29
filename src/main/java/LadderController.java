package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
