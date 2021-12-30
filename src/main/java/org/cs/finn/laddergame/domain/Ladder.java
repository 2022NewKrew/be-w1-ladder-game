package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.domain.ladder.BridgeType;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.cs.finn.laddergame.domain.ladder.LadderRow;
import org.cs.finn.laddergame.domain.ladder.LadderRows;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final String BARRIER = "|";
    public static final int BLANK_LEFT = Member.WIDTH / 2 + 1;

    private final LadderRows ladderRows;

    public Ladder(final SecureRandom sRand, final LadderHeight ladderHeight, final Member member) {
        if (sRand == null) {
            throw new RuntimeException("SecureRandom is null!");
        }
        if (ladderHeight == null) {
            throw new RuntimeException("LadderHeight is null!");
        }
        if (member == null) {
            throw new RuntimeException("Member is null!");
        }

        ladderRows = build(sRand, ladderHeight, member);
    }

    private LadderRows build(final SecureRandom sRand, final LadderHeight ladderHeight, final Member member) {
        final int memberSize = member.getMemberList().size();
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
            bridgeType = (bridgeType == BridgeType.LINE ? BridgeType.EMPTY : BridgeType.getRandomBridge(sRand));
            list.add(bridgeType);
        }

        return new LadderRow(list);
    }

    public LadderRows getLadderRows() {
        return this.ladderRows;
    }
}
