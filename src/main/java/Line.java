import java.util.ArrayList;
import java.util.List;

/**
 * 선을 나타내는 객체입니다.
 * 왼쪽 선, 오른쪽 선과 연결되어있는지 확인하기 위해서 List<Boolean> 객체를 이용하고 있습니다. 인덱스는 높이를 의미하고, 값은 연결 여부를 의미합니다.
 */
public class Line {
    private final List<Boolean> isLeftLineConnected;
    private final List<Boolean> isRightLineConnected;

    private final boolean isFirstLine;
    private final boolean isLastLine;

    public Line(int lineIndex, int playerNum, int maxLadderHeight) {
        this.isLeftLineConnected = createConnectedList(maxLadderHeight);
        this.isRightLineConnected = createConnectedList(maxLadderHeight);

        this.isFirstLine = lineIndex == 0;
        this.isLastLine = lineIndex == playerNum - 1;
    }

    /**
     * 선을 오른쪽으로 연결합니다.
     */
    public void connectToRight(int height) {
        this.isRightLineConnected.set(height, true);
    }

    /**
     * 선을 왼쪽으로 연결합니다.
     */
    public void connectToLeft(int height) {
        this.isLeftLineConnected.set(height, true);
    }

    /**
     * 현재 선과 오른쪽 선이 연결되어있는지 확인합니다.
     */
    public boolean isRightConnected(int height) {
        return this.isRightLineConnected.get(height);
    }

    /**
     * 현재 선과 왼쪽 선이 연결되어있는지 확인합니다.
     */
    public boolean isLeftConnected(int height) {
        return this.isLeftLineConnected.get(height);
    }

    /**
     * 현재 선이 왼쪽 또는 오른쪽과 연결되어있는지 확인합니다.
     * 하나라도 연결되어있다면 true를 반환합니다.
     */
    public boolean isConnected(int height) {
        if(isFirstLine()) {
            return isRightConnected(height);
        }
        if(isLastLine()) {
            return isLeftConnected(height);
        }
        return isRightConnected(height) || isLeftConnected(height);
    }

    /**
     * 현재 선이 사다리에서 마지막에 위치하는지 여부를 반환합니다.
     */
    public boolean isLastLine() {
        return isLastLine;
    }

    /**
     * 현재 선이 사다리에서 첫번째에 위치하는지 여부를 반환합니다.
     */
    public boolean isFirstLine() {
        return isFirstLine;
    }

    private List<Boolean> createConnectedList(int maxLadderHeight) {
        List<Boolean> connectedList = new ArrayList<>();
        for(int i = 0; i < maxLadderHeight; i++) {
            connectedList.add(false);
        }
        return connectedList;
    }
}
