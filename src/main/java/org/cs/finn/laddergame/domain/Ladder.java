package org.cs.finn.laddergame.domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<String> ladderRows = new ArrayList<>();

    private final SecureRandom sRand;

    public Ladder(SecureRandom sRand) {
        if (sRand == null) {
            throw new RuntimeException("SecureRandom is null!");
        }
        this.sRand = sRand;
    }

    public void build(final Input input) {
        if (input == null) {
            throw new RuntimeException("Input for build Ladder is null!");
        }

        final int member = input.getMember();
        final int bound = 1 << (member - 1);
        final int height = input.getLadderHeight();

        for (int i = 0; i < height; i++) {
            // bound를 추가로 더해서
            // 사다리를 놓을 수 있는 최대 개수 + 1 위치에 1을 항상 추가하여
            // Zero-fill 처리하고 가장 위쪽 1을 잘라낸 뒤 저장한다
            final String ladderRow = Integer.toBinaryString(bound + sRand.nextInt(bound));
            ladderRows.add(ladderRow.substring(1));
        }
    }

    public List<String> getLadderRows() {
        return this.ladderRows;
    }
}
