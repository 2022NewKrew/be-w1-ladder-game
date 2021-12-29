package upperleaf.laddergame.domain;

import upperleaf.laddergame.game.GameStartInfo;

import java.util.ArrayList;
import java.util.List;

/**
** 사다리를 표현하는 객체입니다.
 */
public class Ladder {
    private final List<Line> lines;
    private final GameStartInfo gameStartInfo;

    public Ladder(GameStartInfo info) {
        this.lines = createLines(info.getGamePlayerNum(), info.getMaxLadderHeight());
        this.gameStartInfo = info;
    }

    /**
    ** 선택된 선에서 오른쪽 선으로 연결합니다.
    ** 오른쪽 선에서 선택된 선으로도 연결합니다.
     */
    public void connectToRight(int line, int height) {
        if (!isConnectableToRight(line, height)) {
            throw new IllegalStateException("사다리를 연결할 수 없습니다.");
        }
        this.lines.get(line).connectToRight(height);
        this.lines.get(line + 1).connectToLeft(height);
    }

    /**
    ** 현재 선에서 오른쪽이 연결되어있는지 확인합니다.
     */
    public boolean isRightConnected(int line, int height) {
        return lines.get(line).isRightConnected(height);
    }

    /**
     ** 현재 선에서 오른쪽으로 연결할 수 있는지 확인합니다.
     ** 현재 선과 오른쪽 선 모두 연결되어있는 선이 없어야 합니다.
     */
    public boolean isConnectableToRight(int line, int height) {
        if(line == lines.size() - 1) {
            return false;
        }
        return !lines.get(line).isConnected(height) && !lines.get(line + 1).isConnected(height);
    }

    public List<String> getPlayerNames() {
        return gameStartInfo.getPlayerNames();
    }

    public int getMaxLadderHeight() {
        return gameStartInfo.getMaxLadderHeight();
    }

    public int getPlayerNum() {
        return gameStartInfo.getGamePlayerNum();
    }

    /**
    ** 사람들의 숫자만큼 선을 생성합니다.
     */
    private List<Line> createLines(int playerNum, int maxLadderHeight) {
        List<Line> lines = new ArrayList<>();
        for(int lineIndex = 0; lineIndex < playerNum; lineIndex++) {
            lines.add(new Line(lineIndex, playerNum, maxLadderHeight));
        }
        return lines;
    }
}
