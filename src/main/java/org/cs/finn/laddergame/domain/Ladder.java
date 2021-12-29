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

    private final LadderRows ladderRows = new LadderRows();
    private final LadderHeight ladderHeight = new LadderHeight();

    private final SecureRandom sRand;

    public Ladder(SecureRandom sRand) {
        if (sRand == null) {
            throw new RuntimeException("SecureRandom is null!");
        }
        this.sRand = sRand;
    }

    public void build(final Member member) {
        if (member == null) {
            throw new RuntimeException("Member is null!");
        }

        final int memberVal = member.getMember();
        final int ladderHeightVal = ladderHeight.getLadderHeight();

        for (int i = 0; i < ladderHeightVal; i++) {
            ladderRows.add(generateLadderRow(memberVal - 1));
        }
    }

    private LadderRow generateLadderRow(final int size) {
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

    public LadderHeight getLadderHeight() {
        return this.ladderHeight;
    }
}
