package ladder.domain;

import java.util.ArrayList;
import java.util.List;

//사다리 정보
public class Ladder {
    private List<Line> ladder; //실질적인 사다리를 나타내는 컬렉션

    //높이,너비 데이터 바탕으로 생성하는 생성자
    public Ladder() {
        ladder = new ArrayList<>();
    }

    // 사다리 초기화
    public void initLadder(int playerCnt, int height) {
        ladder.clear();

        for (int i = 0; i < playerCnt; i++) {
            ladder.add(new Line(height));
        }
    }

    public int getHeight() {
        return ladder.get(0).getHeight();
    }

    public int getWidth() {
        return ladder.size();
    }

    public List<Line> getLadder() {
        return ladder;
    }

    // 인덱스에 해당하는 라인
    public Line getOneLine(int index) {
        return ladder.get(index);
    }

    //사다리 브릿지 그리기
    public void drawBridge(int lineIdx, int bridgeIdx) {
        if (!checkLadderPolicy(lineIdx, bridgeIdx)) {
            return;
        }
        Line line = ladder.get(lineIdx);
        Bridge bridge = line.getOneBridge(bridgeIdx);

        bridge.drawBridge();
    }

    //사다리 정책에 맞게 체크
    public boolean checkLadderPolicy(int lineIdx, int bridgeIdx) {
        if (lineIdx == 0) {
            return getOneLine(lineIdx + 1).checkBridgeExist(bridgeIdx); // 오른쪽에 bridge 존재하는지 체크
        } else if (lineIdx == getWidth() - 1) {
            return getOneLine(lineIdx - 1).checkBridgeExist(bridgeIdx);
        }
        return getOneLine(lineIdx - 1).checkBridgeExist(bridgeIdx)
                && getOneLine(lineIdx + 1).checkBridgeExist(bridgeIdx); // 양쪽에 bridge 존재하는지 체크
    }
}
