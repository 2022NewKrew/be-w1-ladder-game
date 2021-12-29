package com.chanminkim.w1.view;

import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderState;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderConverter {
    private static final Integer PIECE_WIDTH = 5;
    private static final Map<LadderState, String> STATE_STRING_MAP = Map.ofEntries(
            Map.entry(LadderState.EMPTY, " ".repeat(PIECE_WIDTH)),
            Map.entry(LadderState.VERTICAL, "|"),
            Map.entry(LadderState.HORIZONTAL, "-".repeat(PIECE_WIDTH))
    );

    public static String convertToString(Ladder ladder) {
        return ladder.getLines().stream()
                .map(line -> line.getStates().stream()
                        .map(STATE_STRING_MAP::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
