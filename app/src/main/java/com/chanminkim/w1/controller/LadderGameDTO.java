package com.chanminkim.w1.controller;

import java.util.Random;

public class LadderGameDTO {
    private Integer numberOfPlayers;
    private Integer heightOfLadder;
    private Random random;

    public LadderGameDTO(Integer numberOfPlayers, Integer heightOfLadder, Random random) {
        this.numberOfPlayers = numberOfPlayers;
        this.heightOfLadder = heightOfLadder;
        this.random = random;
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

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
