package com.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGame {
    private final List<List<Boolean>> results = new ArrayList<>();

    public int participantNumber;

    public int ladderHeight;

    public LadderGame(int participantNumber, int ladderHeight) {
        this.participantNumber = participantNumber;
        this.ladderHeight = ladderHeight;
    }

    public List<List<Boolean>> startGame() {
        Random random = new Random();
        for(int i = 0; i < ladderHeight; i++) {
            List<Boolean> roundResults = startEachRound(random);
            results.add(roundResults);
        }
        return results;
    }

    private List<Boolean> startEachRound(Random random) {
        List<Boolean> results = new ArrayList<>();
        for(int i = 0; i < participantNumber - 1; i++) {
            int randomNumber = random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
            boolean result = randomNumber < RANDOM_NUMBER_UPPER_BOUND / 2;
            results.add(result);
        }
        return results;
    }

    static int RANDOM_NUMBER_UPPER_BOUND = 10;
}
