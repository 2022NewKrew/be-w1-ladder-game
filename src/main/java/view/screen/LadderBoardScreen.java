package view.screen;

import domain.data.LadderGameResult;
import common.value.DirectionType;
import common.value.Players;
import domain.Ladder;
import domain.data.Goals;
import domain.value.Point;

public class LadderBoardScreen {

    private static final char LINE_CHAR = '|';

    private static final char LADDER_CHAR = '-';

    private static final char EMPTY_LADDER_CHAR = ' ';

    private static final int LADDER_WIDTH = 5;

    public void render(LadderGameResult gameResult) {
        System.out.println("\n사다리 결과");
        printPlayerList(gameResult.getPlayers());
        printLadder(gameResult.getLadder());
        printGoals(gameResult.getGoals());
        System.out.println();
    }

    private void printPlayerList(Players players) {

        int playerCount = players.getCount();

        if(playerCount <= 0) { return; }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < playerCount; i++) {
            sb.append(String.format("%-5s ", players.getPlayerName(i)));
        }

        System.out.println(sb);
    }

    private void printLadder(Ladder ladder) {
        if(ladder.getPlayerCount() <= 0) { return; }
        int height = ladder.getLadderHeight();
        for(int row = 0; row < height; row++) {
            printLadderRow(ladder, row);
        }
    }

    private void printLadderRow(Ladder ladder, int rowIndex) {
        StringBuilder sb = new StringBuilder();
        for(int playerNum = 0; playerNum < ladder.getPlayerCount() - 1; playerNum++) {
            sb.append(convertPointToString(ladder.getVerticalLine(playerNum).getPoint(rowIndex)));
        }
        sb.append(LINE_CHAR);

        System.out.println(sb);
    }

    private static String convertPointToString(Point point) {
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_CHAR);

        char ladderChar = EMPTY_LADDER_CHAR;
        if(point.getDirection() == DirectionType.RIGHT) { ladderChar = LADDER_CHAR; }
        for(int ladderWidth = 0; ladderWidth < LADDER_WIDTH; ladderWidth++) {
            sb.append(ladderChar);
        }

        return sb.toString();
    }

    private void printGoals(Goals goals) {
        int goalCount = goals.getCount();
        if(goalCount <= 0) { return; }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < goalCount; i++) {
            sb.append(String.format("%-5s ", goals.getGoal(i).getValue()));
        }

        System.out.println(sb);
    }
}
