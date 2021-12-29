package com.chanminkim.w1.model;

import java.util.List;

public class LadderGame {
    private final List<Player> players;
    private final Ladder ladder;

    public LadderGame(List<Player> players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
