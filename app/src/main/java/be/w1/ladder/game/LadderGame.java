package be.w1.ladder.game;

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

    private void validatePeopleCount(int peopleCount) throws IllegalArgumentException {
        if (peopleCount < LEAST_PEOPLE_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_PEOPLE_COUNT_MESSAGE);
        }
    }

    private void validateLadderHeight(int ladderHeight) throws IllegalArgumentException {
        if (ladderHeight < LEAST_LADDER_HEIGHT) {
            throw new IllegalArgumentException(ILLEGAL_LADDER_HEIGHT_MESSAGE);
        }
    }

    private void createLadder() {
        for (int lineNumber = 0; lineNumber < ladderHeight; ++lineNumber) {
            createLine(lineNumber);
        }
    }

    // 매 for문 마다 random 객체가 생성된다.
    private void createLine(int lineNumber) {
        Random random = new Random();

        for (int ladderNumber = 0; ladderNumber < ladderCount; ++ladderNumber) {
            ladderArray[lineNumber][ladderNumber] = random.nextBoolean() ? EMPTY_LADDER : FULL_LADDER;
        }
    }

    // StringBuilder를 파라마터로 넘기는 것
    private void printResult() {
        StringBuilder result = new StringBuilder();

        for (int lineNumber = 0; lineNumber < ladderHeight; ++lineNumber) {
            StringBuilder line = getLadderByLine(lineNumber);
            result.append(line)
                  .append(LADDER_SEPARATOR)
                  .append(NEWLINE);
        }

        System.out.print(result);
    }

    private StringBuilder getLadderByLine(int lineNumber) {
        StringBuilder result = new StringBuilder();

        for (int ladderNumber = 0; ladderNumber < ladderCount; ++ladderNumber) {
            result.append(LADDER_SEPARATOR)
                  .append(ladderArray[lineNumber][ladderNumber]);
        }

        return result;
    }
}

