package domain.value;

import common.value.DirectionType;
import common.value.LadderHeight;
import common.value.PlayerCount;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<VerticalLine> verticalLines = new ArrayList<>();

    public Ladder(PlayerCount playerCount, LadderHeight ladderHeight) {
        for(int playerNum = 0; playerNum < playerCount.getValue(); playerNum++) {
            verticalLines.add(new VerticalLine(ladderHeight.getValue()));
        }
    }

    public int getPlayerCount() {
        return verticalLines.size();
    }

    public int getLadderHeight() {
        return verticalLines.size() != 0 ? verticalLines.get(0).getHeight() : 0;
    }

    public VerticalLine getVerticalLine(int index) {
        if(index < 0 || verticalLines.size() <= index) {
            throw new IllegalArgumentException("VerticalLine 인덱스 오류");
        }
        return verticalLines.get(index);
    }

    public void makeHorizontalLine(int playerNum, int height) {
        if(playerNum == getPlayerCount() - 1) { return; }

        VerticalLine leftLine = getVerticalLine(playerNum);
        Point leftPoint = leftLine.getPoint(height);
        leftPoint.setDirection(DirectionType.RIGHT);

        VerticalLine rightLine = getVerticalLine(playerNum + 1);
        Point rightPoint = rightLine.getPoint(height);
        rightPoint.setDirection(DirectionType.LEFT);
    }
}
