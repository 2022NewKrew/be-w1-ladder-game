package com.yapark97.laddergame.ladder.domain.row;

import com.yapark97.laddergame.ladder.domain.LadderBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderRow implements Row {
    private final Random rd = new Random();
    private final List<Boolean> connections;

    public LadderRow(int participantsNum) {
        connections = new ArrayList<>(participantsNum - 1);
        initLadderRow(participantsNum);
    }

    private void initLadderRow(int participantsNum) {
        for (int i=0; i<participantsNum-1; i++) {
            connections.add(createRandomConnection(i));
        }
    }

    private boolean createRandomConnection(int index) {
        if (index > 0 && connections.get(index - 1)) {
            return false;
        }
        return rd.nextBoolean();
    }

    @Override
    public String getSimpleOutput(final int WIDTH) {
        return generatePrefix(WIDTH).concat(generateLadderBlocks(WIDTH));}

    private String generatePrefix(final int WIDTH) {
        return Collections.nCopies(WIDTH/2, LadderBlock.BLANK).stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private String generateLadderBlocks(final int WIDTH) {
        return connections.stream()
                .map(LadderRow::generateLadderBlock) // {'-', ' ', '-'}
                .map(ladderBlock -> Collections.nCopies(WIDTH, ladderBlock).stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining())) // {"-----", "     ", "-----"}
                .collect(Collectors.joining(LadderBlock.VERTICAL_LINE, LadderBlock.VERTICAL_LINE, LadderBlock.VERTICAL_LINE)); // "|-----|     |-----|"
    }

    private static char generateLadderBlock(boolean isConnected) {
        return isConnected ? LadderBlock.HORIZONTAL_LINE : LadderBlock.BLANK;
    }

    @Override
    public int move(int curIndex) {
        if (curIndex > 0 && connections.get(curIndex - 1)) {
            return curIndex - 1;
        }
        if (curIndex < connections.size() && connections.get(curIndex)) {
            return curIndex + 1;
        }
        return curIndex;
    }
}