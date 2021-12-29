package com.chanminkim.w1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LadderConverter {
    static String convertToString(LadderMap ladderMap) {
        return Arrays.stream(ladderMap.getMap())
                .map(line -> Arrays.stream(line)
                        .map(LadderState::getValue)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
