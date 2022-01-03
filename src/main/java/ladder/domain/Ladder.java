package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<LadderLine> ladder;

    public void setLadder(int numOfPlayers, int numOfLine) {
        ladder = new ArrayList<>();

        for (int i = 0; i < numOfLine; i++) {
            LadderLine curLine = new LadderLine();
            curLine.setLine(numOfPlayers);
            ladder.add(curLine);
        }
    }

    public List<LadderLine> getLadder() {
        if (ladder == null) return null;
        return ladder;
    }

    public int getResult(int startPos) {
        int height = 0;

        while (height < ladder.size()) {
            startPos = ladder.get(height).moveToNextPosition(startPos);
            height++;
        }

        return startPos;
    }
}
