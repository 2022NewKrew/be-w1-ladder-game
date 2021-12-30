package view.screen;

import common.value.LadderHeight;
import common.value.Player;
import common.value.Players;
import view.data.UserInputInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputScreen {

    private static final String GET_PLAYER_LIST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final String GET_MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public UserInputInfo render() {
        Players players = getPlayers();
        LadderHeight maxLadderHeight = getMaxLadderHeight();
        return new UserInputInfo(players, maxLadderHeight);
    }

    private Players getPlayers() {
        String playerListString = getUserInputString(GET_PLAYER_LIST_MESSAGE);
        String[] playerArray = playerListString.split(",");

        List<Player> playerList = new ArrayList<>();
        for(String playerName : playerArray) {
            playerList.add(new Player(playerName));
        }

        return new Players(playerList);
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
}
