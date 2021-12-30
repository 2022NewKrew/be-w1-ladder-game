package com.yapark97.laddergame.ladder.view;

import com.yapark97.laddergame.ladder.domain.Ladder;

public interface LadderOutput {
    void drawLadder(Ladder ladder);

    boolean showResult(Ladder ladder, String selection);
}
