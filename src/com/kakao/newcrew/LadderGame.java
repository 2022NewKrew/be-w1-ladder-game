package com.kakao.newcrew;

import java.util.Random;

public class LadderGame {
    private static final String ILLEGAL_PEOPLE_COUNT_MESSAGE = "참여할 사람은 최소 2명 이상이어야 합니다.";
    private static final String ILLEGAL_LADDER_HEIGHT_MESSAGE = "사다리 높이는 최소 1 이상이어야 합니다.";

    private static final int LEAST_PEOPLE_COUNT = 2;
    private static final int LEAST_LADDER_HEIGHT = 1;

    private static final char LADDER_SEPARATOR = '|';
    private static final char FULL_LADDER = '-';
    private static final char EMPTY_LADDER = ' ';
    private static final char NEWLINE = '\n';

    private final int ladderCount;
    private final int ladderHeight;
    private final char[][] ladderArray;

    LadderGame(int peopleCount, int ladderHeight) throws IllegalArgumentException {
        validatePeopleCount(peopleCount);
        validateLadderHeight(ladderHeight);

        this.ladderCount = peopleCount - 1;
        this.ladderHeight = ladderHeight;

        ladderArray = new char[this.ladderHeight][this.ladderCount];
    }

    public void startGame() {
        createLadder();

        printResult();
    }

    private void validatePeopleCount(int peopleCount) {
        if (peopleCount < LEAST_PEOPLE_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_PEOPLE_COUNT_MESSAGE);
        }
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight >= LEAST_LADDER_HEIGHT) {
            throw new IllegalArgumentException(ILLEGAL_LADDER_HEIGHT_MESSAGE);
        }
    }

    private void createLadder() {
        Random random = new Random();

        for (int i = 0; i < ladderHeight; ++i) {
            for (int j = 0; j < ladderCount; ++j) {
                ladderArray[i][j] = random.nextBoolean() ? EMPTY_LADDER : FULL_LADDER;
            }
        }
    }

    private void printResult() {
        StringBuilder result = new StringBuilder();

        for (char[] row : ladderArray) {
            for (char ladder : row) {
                result.append(LADDER_SEPARATOR).append(ladder);
            }
            result.append(LADDER_SEPARATOR).append(NEWLINE);
        }

        System.out.print(result);
    }
}
