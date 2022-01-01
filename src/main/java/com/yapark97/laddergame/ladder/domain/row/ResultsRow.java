package com.yapark97.laddergame.ladder.domain.row;

import com.yapark97.laddergame.ladder.domain.LadderBlock;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsRow implements Row{
    private final List<String> results;

    public ResultsRow(List<String> results) {
        this.results = results;
    }

    @Override
    public String getSimpleOutput(final int WIDTH) {
        return results.stream()
                .map(result -> alignCenter(result, WIDTH))
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

    @Override
    public int move(int curIndex) {
        return curIndex;
    }
}
