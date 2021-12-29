package com.chanminkim.w1.controller;

public class LadderGameDTO {
    private Integer numberOfPlayers;
    private Integer heightOfLadder;

    public LadderGameDTO(Integer numberOfPlayers, Integer heightOfLadder) {
        this.numberOfPlayers = numberOfPlayers;
        this.heightOfLadder = heightOfLadder;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Integer getHeightOfLadder() {
        return heightOfLadder;
    }

    public void setHeightOfLadder(Integer heightOfLadder) {
        this.heightOfLadder = heightOfLadder;
    }

}
