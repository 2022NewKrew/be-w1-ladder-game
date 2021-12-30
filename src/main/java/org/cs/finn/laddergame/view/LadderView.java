package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.ladder.BridgeType;
import org.cs.finn.laddergame.domain.ladder.LadderRow;

public class LadderView {

    public void print(final Ladder ladder) {
        if (ladder == null) {
            throw new RuntimeException("Ladder is null!");
        }

        for (LadderRow ladderRow : ladder.getLadderRows().getLadderRowList()) {
            printOneHeight(ladderRow);
        }
    }

    private void printOneHeight(final LadderRow ladderRow) {
        for (int i = 0; i < Ladder.BLANK_LEFT; i++) {
            System.out.print(' ');
        }
        for (BridgeType bridgeType : ladderRow.getBridgeList()) {
            System.out.print(Ladder.BARRIER + bridgeType.toString());
        }
        System.out.println(Ladder.BARRIER);
    }
}
