package com.chanminkim.w1.controller;

import java.util.List;

public class LadderGameDTO {
    private List<String> players;
    private Integer heightOfLadder;

    public LadderGameDTO(List<String> players, Integer heightOfLadder) {
        this.players = players;
        this.heightOfLadder = heightOfLadder;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public Integer getHeightOfLadder() {
        return heightOfLadder;
    }

    public void setHeightOfLadder(Integer heightOfLadder) {
        this.heightOfLadder = heightOfLadder;
    }

}
