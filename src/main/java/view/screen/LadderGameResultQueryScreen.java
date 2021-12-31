package view.screen;

import common.value.Player;
import common.value.Players;
import domain.data.LadderGameResult;
import domain.data.Goal;

import static view.util.UserInputManager.*;

public class LadderGameResultQueryScreen {

    private static final String QUERY_LADDER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

    private static final String VIEW_LADDER_RESULT_MESSAGE = "실행 결과";

    public void render(LadderGameResult ladderGameResult) {
        while(printQueryPlayerName(ladderGameResult)) {}
    }

    private boolean printQueryPlayerName(LadderGameResult ladderGameResult) {
        String playerName = getUserInputString(QUERY_LADDER_RESULT_MESSAGE);
        switch (playerName) {
            case "춘식이" :
                return false;
            case "all":
                System.out.println(VIEW_LADDER_RESULT_MESSAGE);
                printLadderGameResultAll(ladderGameResult);
                return true;
            default:
                System.out.println(VIEW_LADDER_RESULT_MESSAGE);
                printLadderGameResult(ladderGameResult, playerName);
                return true;
        }
    }

    private void printLadderGameResultAll(LadderGameResult ladderGameResult) {
        Players players = ladderGameResult.getPlayers();
        for(int i = 0; i < players.getCount(); i++) {
            Player player = players.getPlayer(i);
            Goal goal = ladderGameResult.queryResult(player.getName());
            System.out.printf("%s : %s\n", player.getName(), goal.getValue());
        }
    }

    private void printLadderGameResult(LadderGameResult ladderGameResult, String playerName) {
        Goal result = ladderGameResult.queryResult(playerName);
        System.out.println(result.getValue());
    }
}
