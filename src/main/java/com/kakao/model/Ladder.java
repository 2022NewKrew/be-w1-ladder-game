package com.kakao.model;

import com.kakao.random.RandomStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int START_OF_ROW = 0;
    private static final int START_OF_BRIDGE = 1;

    private GamePlayers gamePlayers;
    private GameRewards gameRewards;
    private int ladderHeight;
    private List<List<Boolean>> bridgeOfLadder; // 사다리 연결 정보

    private RandomStrategy<Boolean> randomStrategy; // 랜덤 생성 규칙

    // 생성자
    public Ladder(GamePlayers gamePlayers, GameRewards gameRewards, int ladderHeight, RandomStrategy<Boolean> randomStrategy) {
        this.gamePlayers = gamePlayers;
        this.gameRewards = gameRewards;
        this.ladderHeight = ladderHeight;
        this.randomStrategy = randomStrategy;

        this.bridgeOfLadder = makeLadder();
    }

    // Getter
    public String[] getGamePlayers() {
        return gamePlayers.getPlayers();
    }
    public String[] getGameRewards() {
        return gameRewards.getRewards();
    }
    public List<List<Boolean>> getBridgeOfLadder() {
        return bridgeOfLadder;
    }

    // 사다리 생성
    private List<List<Boolean>> makeLadder() {
        List<List<Boolean>> bridgeOfLadder = new ArrayList<>();
        for(int h = this.START_OF_ROW; h<this.ladderHeight; h++) { // 한 줄씩 사다리를 생성
            bridgeOfLadder.add(makeRow());
        }
        return bridgeOfLadder;
    }
    private List<Boolean> makeRow() { // 한 줄의 사다리 생성
        List<Boolean> row = new ArrayList<>();

        int numberOfPlayers = this.gamePlayers.getNumberOfPlayers();
        boolean lastBridge = false;
        for(int w = this.START_OF_BRIDGE; w<numberOfPlayers; w++) {
            lastBridge = getRandomBrigde(lastBridge);
            row.add(lastBridge); // 연결점 생성
        }
        return row;
    }
    private boolean getRandomBrigde(boolean lastBridge) {
        // 중복 연결을 제거하기 위한 용도의 함수
        return lastBridge ? false : randomStrategy.random();
    }
}
