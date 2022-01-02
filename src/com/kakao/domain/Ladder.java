package com.kakao.domain;

import java.util.*;

public class Ladder {

    private final List<String> participants;
    private final int height;
    private final List<String> results;
    private final List<Line> ladder = new ArrayList<>();
    private final Map<String, String> awards = new HashMap<>();

    public Ladder(List<String> participants, int height, List<String> results) {
        this.participants = participants;
        this.height = height;
        this.results = results;
        setLadder();
        playGame();
    }

    public List<String> getParticipants() { return participants; }

    public List<String> getResults() { return results; }

    public List<Line> getLadder() { return ladder; }

    public Map<String, String> getAwards() { return awards; }

    private void setLadder() {
        for (int i = 0; i < height; i++) {
            Line line = new Line(participants);
            ladder.add(line);
        }
    }

    private void setAwards(List<String> gameResult) {
        int participantCnt = participants.size();
        for (int i = 0; i < participantCnt; i++) {
            String participant = gameResult.get(i);
            String award = results.get(i);
            awards.put(participant, award);
        }
    }

    private void playGame() {
        List<String> gameResult = new ArrayList<>(participants);
        for (Line line : ladder) {
            gameResult = line.playGame(gameResult);
        }
        setAwards(gameResult);
    }
}
