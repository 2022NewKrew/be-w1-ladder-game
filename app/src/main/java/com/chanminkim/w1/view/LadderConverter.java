package com.chanminkim.w1.view;

import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderState;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderConverter {
    private static final Map<LadderState, String> STATE_STRING_MAP = Map.ofEntries(
            Map.entry(LadderState.EMPTY, " "),
            Map.entry(LadderState.VERTICAL, "|"),
            Map.entry(LadderState.HORIZONTAL, "-")
    );

    public static String convertToString(Ladder ladder) {
        return ladder.getLines().stream()
                .map(line -> line.getStates().stream()
                        .map(STATE_STRING_MAP::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
