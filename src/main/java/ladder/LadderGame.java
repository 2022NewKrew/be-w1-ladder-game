package ladder;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.Line;
import ladder.dto.InputDTO;
import ladder.util.RandomUtil;

public class LadderGame {

    private List<Line> ladder;

    public LadderGame(InputDTO inputComponent) {
        ladder = new ArrayList<>();
        makeHorizonLadder(inputComponent.getNamesOfPeople().length,
                inputComponent.getHeightOfLadder());
    }

    public List<Line> getLadder() {
        return this.ladder;
    }

    private void makeHorizonLadder(int peopleCnt, int ladderHeight) {
        for (int row = 0; row < ladderHeight; row++) {
            ladder.add(new Line());
            makeVerticalLadder(peopleCnt, row);
        }

    }

    private void makeVerticalLadder(int peopleCnt, int row) {
        boolean previousLink = false;
        boolean isLink;
        Line curHorizonLine = ladder.get(row);

        for (int col = 0; col < peopleCnt - 1; col++) {
            isLink = RandomUtil.INSTANCE.generateBoolean();
            curHorizonLine.setAbleLink(checkAbleLink(previousLink, isLink));
            previousLink = isLink;
        }
    }


    private boolean checkAbleLink(boolean previousLink, boolean isLink) {
        if (!previousLink && isLink)
            return true;

        return false;
    }
}