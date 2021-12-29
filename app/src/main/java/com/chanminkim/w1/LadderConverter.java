package com.chanminkim.w1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderConverter {
    private static final Map<LadderState, String> STATE_STRING_MAP = Map.ofEntries(
            Map.entry(LadderState.EMPTY, " "),
            Map.entry(LadderState.VERTICAL, "|"),
            Map.entry(LadderState.HORIZONTAL, "-")
    );

    public static String convertToString(Ladder ladder) {
        return Arrays.stream(ladder.getMap())
                .map(line -> Arrays.stream(line)
                        .map(STATE_STRING_MAP::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
