package com.yapark97.laddergame.ladder.view;

import com.yapark97.laddergame.ladder.domain.Ladder;

import java.util.List;

public interface LadderInput {
    List<String> takeParticipantsInput();

    int takeMaxHeightInput();

    List<String> takeResultsInput(int num);

    String selectParticipant(Ladder ladder);
}
