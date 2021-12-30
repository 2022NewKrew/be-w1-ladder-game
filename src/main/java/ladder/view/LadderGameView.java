package main.java.ladder.view;

import main.java.ladder.domain.Ladder;
import main.java.ladder.domain.LadderGame;

import java.util.List;
import java.util.Optional;

public class LadderGameView {
    private static final String NEW_LINE = "\n";

    private final List<String> players;
    private final LadderGame ladderGame;

    public LadderGameView(Ladder ladder, List<String> players, List<String> results) {
        this.players = players;
        ladderGame = new LadderGame(ladder, players, results);
    }

    public String printResult(String player) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);
        if (player.equals("all")) {
            sb.append(printAllResult());
            return sb.toString();
        }
        sb.append(printOneResult(player)).append(NEW_LINE);
        return sb.toString();
    }

    private String printOneResult(String player) {
        return Optional.ofNullable(ladderGame.getOnePlayerResult(player))
                .orElse("존재하지 않는 플레이어입니다.");
    }

    private String printAllResult() {
        StringBuilder sb = new StringBuilder();
        players.forEach(player ->
                sb.append(player).append(" : ").append(ladderGame.getOnePlayerResult(player)).append(NEW_LINE)
        );
        return sb.toString();
    }
}