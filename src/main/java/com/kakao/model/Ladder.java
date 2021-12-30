package com.kakao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int START_OF_ROW = 0;
    private static final int START_OF_BRIDGE = 1;
    private static final Random random = new Random();

    private String[] gamePlayers, gameRewards;
    private int ladderHeight;
    private List<List<Boolean>> bridgeOfLadder; // 사다리 연결 정보

    // 생성자
    public Ladder(String[] gamePlayers, String[] gameRewards, int ladderHeight) {
        this.gamePlayers = gamePlayers;
        this.gameRewards = gameRewards;
        this.ladderHeight = ladderHeight;
        this.bridgeOfLadder = makeLadder(gamePlayers, ladderHeight);
    }



    // Getter
    public String[] getGamePlayers() {
        return gamePlayers;
    }
    public String[] getGameRewards() {
        return gameRewards;
    }
    public List<List<Boolean>> getBridgeOfLadder() {
        return bridgeOfLadder;
    }

    // 사다리 생성
    private List<List<Boolean>> makeLadder(String[] gamePlayers, int ladderHeight) {
        List<List<Boolean>> bridgeOfLadder = new ArrayList<>();
        for(int h = this.START_OF_ROW; h<this.ladderHeight; h++) { // 한 줄씩 사다리를 생성
            bridgeOfLadder.add(makeRow());
        }
        return bridgeOfLadder;
    }
    private List<Boolean> makeRow() { // 한 줄의 사다리 생성
        List<Boolean> row = new ArrayList<>();
        boolean lastBridge = false;
        for(int w = this.START_OF_BRIDGE; w<this.gamePlayers.length; w++) {
            lastBridge = getRandomBrigde(lastBridge);
            row.add(lastBridge); // 연결점 생성
        }
        return row;
    }
    private boolean getRandomBrigde(boolean lastBridge) {
        // 중복 연결을 제거하기 위한 용도의 함수
        return lastBridge ? false : random.nextBoolean();
    }
}
