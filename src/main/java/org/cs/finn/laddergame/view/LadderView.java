package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.ladder.BridgeType;
import org.cs.finn.laddergame.domain.ladder.LadderRow;

import java.util.List;

public class LadderView {
    private static final char REWARD_PATH = '*';

    public void print(final Ladder ladder) {
        if (ladder == null) {
            throw new RuntimeException("Ladder is null!");
        }

        for (LadderRow ladderRow : ladder.getLadderRows().getLadderRowList()) {
            printOneHeight(ladderRow);
        }
    }

    private void printOneHeight(final LadderRow ladderRow) {
        printLeftBlank();

        for (BridgeType bridgeType : ladderRow.getBridgeList()) {
            System.out.print(Ladder.BARRIER + bridgeType.toString());
        }
        System.out.println(Ladder.BARRIER);
    }

    private void printLeftBlank() {
        for (int i = 0; i < Ladder.BLANK_LEFT; i++) {
            System.out.print(' ');
        }
    }

    public int printWithReward(final Ladder ladder, final int idx) {
        if (idx < 0) {
            throw new RuntimeException("width is not 0 or positive integer! - " + idx);
        }
        if (ladder == null) {
            throw new RuntimeException("ladder is null!");
        }

        int curIdx = idx;
        for (LadderRow ladderRow : ladder.getLadderRows().getLadderRowList()) {
            curIdx = printOneHeightWithReward(ladderRow, curIdx);
        }
        return curIdx;
    }

    private int printOneHeightWithReward(final LadderRow ladderRow, final int idx) {
        printLeftBlank();

        final List<BridgeType> list = ladderRow.getBridgeList();
        BridgeType beforeBridge = BridgeType.EMPTY;
        int curIdx = idx;
        for (int i = 0; i < list.size(); i++) {
            BridgeType bridge = list.get(i);
            curIdx = printOneBridgeWithRewardPath(bridge, beforeBridge, i, curIdx);
            beforeBridge = bridge;
        }
        curIdx = printOneBridgeWithRewardPath(BridgeType.EMPTY, beforeBridge, list.size(), curIdx);
        System.out.println();
        return curIdx;
    }

    private int printOneBridgeWithRewardPath(
            final BridgeType bridge,
            final BridgeType beforeBridge,
            final int idx,
            final int targetIdx
    )
    {
        if (bridge == BridgeType.LINE && idx == targetIdx) {
            System.out.print(replaceWithPathChar(Ladder.BARRIER));
            System.out.print(replaceWithPathChar(bridge.toString()));
            return targetIdx + 1;
        }
        if (bridge == BridgeType.LINE && (idx + 1) == targetIdx) {
            System.out.print(replaceWithPathChar(Ladder.BARRIER));
            System.out.print(replaceWithPathChar(bridge.toString()));
            return targetIdx - 1;
        }
        if (idx == targetIdx || (beforeBridge == BridgeType.LINE && idx == targetIdx + 1)) {
            System.out.print(replaceWithPathChar(Ladder.BARRIER));
            System.out.print(bridge);
            return targetIdx;
        }
        System.out.print(Ladder.BARRIER);
        System.out.print(bridge);
        return targetIdx;
    }

    private String replaceWithPathChar(final String str) {
        return String.valueOf(REWARD_PATH)
                .repeat(str.length());
    }
}
