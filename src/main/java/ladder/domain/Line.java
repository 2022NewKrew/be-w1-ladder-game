package ladder.domain;

import java.util.ArrayList;
import java.util.List;

// 사다리를 구성하는 한 라인
public class Line {
    private List<Bridge> bridges; //라인은 브릿지의 모음

    public Line(int height) {
        bridges = new ArrayList<>(height);
    }

    //라인 초기화
    public void initLine(int height) {
        bridges.clear();

        for (int i = 0; i < height; i++) {
            bridges.add(new Bridge());
        }
    }

    public List<Bridge> getLine() {
        return bridges;
    }

    public int getHeight() {
        return bridges.size();
    }

    public Bridge getOneBridge(int index) {
        return bridges.get(index);
    }

    //브릿지 존재 여부 검증
    public boolean checkBridgeExist(int bridgeIdx) {
        Bridge bridge = bridges.get(bridgeIdx);

        if (bridge.isExist()) {
            return false;
        }
        return true;
    }
}
