package com.yapark97.laddergame.ladder.domain.row;

import com.yapark97.laddergame.ladder.domain.LadderBlock;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantsRow implements Row {
    private final List<String> participants;

    public ParticipantsRow(List<String> participants) {
        this.participants = participants;
    }

    @Override
    public String getSimpleOutput(final int WIDTH) {
        return participants.stream()
                .map(participant -> alignCenter(participant, WIDTH))
                .collect(Collectors.joining(" "));
    }

    private String alignCenter(String mid, final int WIDTH) {
        if (mid.length() > 5) {
            mid = mid.substring(0, WIDTH);
        }
        String leftPadding = Collections.nCopies((WIDTH - mid.length()) / 2, LadderBlock.BLANK).stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String rightPadding = Collections.nCopies(WIDTH - leftPadding.length() - mid.length(), LadderBlock.BLANK).stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return leftPadding + mid + rightPadding;
    }
}
