package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.cs.finn.laddergame.domain.ladder.LadderRows;

import java.security.SecureRandom;

public class Ladder {
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
        final int bound = 1 << (memberVal - 1);
        final int ladderHeightVal = ladderHeight.getLadderHeight();

        for (int i = 0; i < ladderHeightVal; i++) {
            // bound를 추가로 더해서
            // 사다리를 놓을 수 있는 최대 개수 + 1 위치에 1을 항상 추가하여
            // Zero-fill 처리하고 가장 위쪽 1을 잘라낸 뒤 저장한다
            final String ladderRow = Integer.toBinaryString(bound + sRand.nextInt(bound));
            ladderRows.add(ladderRow.substring(1));
        }
    }

    public LadderRows getLadderRows() {
        return this.ladderRows;
    }

    public LadderHeight getLadderHeight() {
        return this.ladderHeight;
    }
}
