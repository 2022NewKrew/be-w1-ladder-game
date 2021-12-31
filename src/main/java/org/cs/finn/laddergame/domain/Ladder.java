package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.domain.ladder.BridgeType;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.cs.finn.laddergame.domain.ladder.LadderRow;
import org.cs.finn.laddergame.domain.ladder.LadderRows;
import org.cs.finn.laddergame.domain.stringvalues.Member;
import org.cs.finn.laddergame.domain.stringvalues.Members;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final String BARRIER = "|";
    public static final int BLANK_LEFT = Member.WIDTH / 2 + 1;

    private final LadderRows ladderRows;

    public Ladder(final SecureRandom sRand, final LadderHeight ladderHeight, final Members members) {
        if (sRand == null) {
            throw new RuntimeException("SecureRandom is null!");
        }
        if (ladderHeight == null) {
            throw new RuntimeException("LadderHeight is null!");
        }
        if (members == null) {
            throw new RuntimeException("Members is null!");
        }

        ladderRows = build(sRand, ladderHeight, members);
    }

    private LadderRows build(final SecureRandom sRand, final LadderHeight ladderHeight, final Members members) {
        final int memberSize = members.getList().size();
        final int rows = ladderHeight.getLadderHeight();
        final List<LadderRow> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            list.add(generateLadderRow(sRand, memberSize - 1));
        }

        return new LadderRows(list);
    }

    private LadderRow generateLadderRow(final SecureRandom sRand, final int size) {
        final List<BridgeType> list = new ArrayList<>();

        BridgeType bridgeType = BridgeType.EMPTY;
        for (int i = 0; i < size; i++) {
            bridgeType = getNextBridge(sRand, bridgeType);
            list.add(bridgeType);
        }

        return new LadderRow(list);
    }

    private BridgeType getNextBridge(final SecureRandom sRand, final BridgeType before) {
        if (before == BridgeType.LINE) {
            return BridgeType.EMPTY;
        }
        return BridgeType.getRandomBridge(sRand);
    }

    public LadderRows getLadderRows() {
        return this.ladderRows;
    }
}
