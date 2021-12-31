package view.screen;

import common.value.LadderHeight;
import common.value.Player;
import common.value.Players;
import domain.data.Goal;
import domain.data.Goals;
import view.data.UserInputInfo;

import java.util.ArrayList;
import java.util.List;

import static view.util.UserInputManager.*;

public class UserInputScreen {

    private static final String INSERT_PLAYER_LIST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final String INSERT_LADDER_RESULT_LIST_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private static final String INSERT_MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public UserInputInfo render() {
        Players players = getPlayers();
        Goals ladderResults = getLadderResults();
        LadderHeight maxLadderHeight = getMaxLadderHeight();
        return new UserInputInfo(players, ladderResults, maxLadderHeight);
    }

    private Players getPlayers() {
        String[] playerArray = getUserInputString(INSERT_PLAYER_LIST_MESSAGE).split(",");

        List<Player> playerList = new ArrayList<>();
        for(String playerName : playerArray) {
            playerList.add(new Player(playerName));
        }

        return new Players(playerList);
    }

    private Goals getLadderResults() {
        String[] ladderResultArray = getUserInputString(INSERT_LADDER_RESULT_LIST_MESSAGE).split(",");

        List<Goal> ladderResultList = new ArrayList<>();
        for(String ladderResult : ladderResultArray) {
            ladderResultList.add(new Goal(ladderResult));
        }

        return new Goals(ladderResultList);
    }

    private LadderHeight getMaxLadderHeight() {
        int maxHeightOfLadder = getUserInputInt(INSERT_MAX_LADDER_HEIGHT_MESSAGE);
        return new LadderHeight(maxHeightOfLadder);
    }

}
