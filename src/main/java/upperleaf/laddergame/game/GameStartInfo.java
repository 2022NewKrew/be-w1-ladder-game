package upperleaf.laddergame.game;

import java.util.List;

/**
** 게임 정보를 표현하는 객체입니다.
** 참여하는 사람들의 이름, 사람들의 숫자, 최대 사다리 높이를 가지고 있습니다.
 */
public class GameStartInfo {
    private final List<String> playerNames;
    private final int gamePlayerNum;
    private final int maxLadderHeight;

    public GameStartInfo(List<String> playerNames, int maxLadderHeight) {
        valid(playerNames, maxLadderHeight);
        this.gamePlayerNum = playerNames.size();
        this.maxLadderHeight = maxLadderHeight;
        this.playerNames = playerNames;
    }

    private void valid(List<String> playerNames, int maxLadderHeight) {
        if(playerNames.size() <= 0 || maxLadderHeight < 1) {
            throw new IllegalArgumentException("게임 정보를 생성할 수 없습니다.");
        }
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public int getGamePlayerNum() {
        return gamePlayerNum;
    }

    public int getMaxLadderHeight() {
        return maxLadderHeight;
    }
}
