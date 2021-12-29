package ui;

import configuration.LadderHeight;
import configuration.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LadderGameUI {

    private static final String GET_PEOPLE_LIST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final String GET_MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public List<Player> getPeopleList() {
        String playerListString = getUserInputString(GET_PEOPLE_LIST_MESSAGE);
        String[] playerArray = playerListString.split(",");

        List<Player> playerList = new ArrayList<>();
        for(String playName : playerArray) {
            playerList.add(new Player(playName));
        }

        return playerList;
    }

    public LadderHeight getMaxLadderHeight() {
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

}
