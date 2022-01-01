package com.yapark97.laddergame.ladder;

import com.yapark97.laddergame.ladder.domain.Ladder;
import com.yapark97.laddergame.ladder.view.LadderInput;
import com.yapark97.laddergame.ladder.view.LadderOutput;
import com.yapark97.laddergame.ladder.view.SimpleLadderInput;
import com.yapark97.laddergame.ladder.view.SimpleLadderOutput;

import java.util.*;

public class LadderGame {
    private final LadderInput ladderInput;
    private final LadderOutput ladderOutput;
    private Ladder ladder = null;

    public LadderGame() {
        ladderInput = SimpleLadderInput.getInstance();
        ladderOutput = SimpleLadderOutput.getInstance();
    }

    public void initGame() {
        ladder = createLadder();
    }

    private Ladder createLadder() {
        List<String> participants = ladderInput.takeParticipantsInput();
        int maxHeight = ladderInput.takeMaxHeightInput();
        List<String> results = ladderInput.takeResultsInput(participants.size());

        return new Ladder(participants, maxHeight, results);
    }

    public void drawLadder() {
        ladderOutput.drawLadder(ladder);
    }

    public void play() {
        boolean isFinished;

        do {
            String selection = ladderInput.selectParticipant(ladder);
            isFinished = ladderOutput.showResult(ladder, selection);
        } while (!isFinished);
    }
}
