package ui;

import common.data.GameResult;
import common.value.LadderHeight;
import common.value.Player;
import service.value.Line;
import service.value.Point;
import ui.data.UserInputInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LadderGameUI {

    private static final String GET_PLAYER_LIST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final String GET_MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final char LINE_CHAR = '|';

    private static final char LADDER_CHAR = '-';

    private static final char EMPTY_LADDER_CHAR = ' ';

    private static final int LADDER_WIDTH = 5;

    private static final int LEFT = 0;

    private static final int DOWN = 1;

    private static final int RIGHT = 2;

    private static Scanner scanner = new Scanner(System.in);

    public UserInputInfo renderUserInputScreen() {
        List<Player> playerList = getPlayerList();
        LadderHeight maxLadderHeight = getMaxLadderHeight();
        return new UserInputInfo(playerList, maxLadderHeight);
    }

    public void renderLadderBoard(GameResult gameResult) {
        printPlayerList(gameResult.getPlayerList());
        printLadderRows(gameResult.getLadders());
    }

    private List<Player> getPlayerList() {
        String playerListString = getUserInputString(GET_PLAYER_LIST_MESSAGE);
        String[] playerArray = playerListString.split(",");

        List<Player> playerList = new ArrayList<>();
        for(String playerName : playerArray) {
            playerList.add(new Player(playerName));
        }

        return playerList;
    }

    private LadderHeight getMaxLadderHeight() {
        int maxHeightOfLadder = getUserInputInt(GET_MAX_LADDER_HEIGHT_MESSAGE);
        return new LadderHeight(maxHeightOfLadder);
    }

    private static int getUserInputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    private static String getUserInputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private void printPlayerList(List<Player> playerList) {
        if(playerList.size() <= 0) { return; }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s", playerList.get(0).getName()));
        for(int i = 1; i < playerList.size() - 1; i++) {
            sb.append(String.format(" %-5s ", playerList.get(i).getName()));
        }
        sb.append(String.format("%5s", playerList.get(playerList.size() - 1).getName()));

        System.out.println(sb);
    }

    private void printLadderRows(List<Line> ladders) {
        if(ladders.size() <= 0) { return; }
        int height = ladders.get(0).getHeight();
        for(int row = 0; row < height; row++) {
            printLadderRow(ladders, row);
        }
    }

    private void printLadderRow(List<Line> ladders, int rowIndex) {
        int width = ladders.size();

        StringBuilder sb = new StringBuilder();
        for(int colIndex = 0; colIndex < width - 1; colIndex++) {
            sb.append(convertPointToString(ladders.get(colIndex).getPoint(rowIndex)));
        }
        sb.append(LINE_CHAR);

        System.out.println(sb);
    }

    private static String convertPointToString(Point point) {
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_CHAR);

        char ladderChar = EMPTY_LADDER_CHAR;
        if(point.getDirection() == RIGHT) { ladderChar = LADDER_CHAR; }
        for(int ladderWidth = 0; ladderWidth < LADDER_WIDTH; ladderWidth++) {
            sb.append(ladderChar);
        }

        return sb.toString();
    }
}
