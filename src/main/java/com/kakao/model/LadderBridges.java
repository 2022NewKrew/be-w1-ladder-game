package com.kakao.model;

import java.util.ArrayList;
import java.util.List;

// 사다리 연결다리
public class LadderBridges {
    private List<List<Boolean>> bridgeOfLadder; // 사다리 연결 정보

    private LadderBridges(){}

//    public static LadderBridges generateLadderBridges() {
//        List<List<Boolean>> bridgeOfLadder = new ArrayList<>();
//        for(int h = this.START_OF_ROW; h<this.ladderHeight; h++) { // 한 줄씩 사다리를 생성
//            bridgeOfLadder.add(makeRow());
//        }
//        return bridgeOfLadder;
//    }

    // 사다리 생성
//    private LadderBridges makeLadder() {
//        LadderBridges ladderBridges =
//
//    }
//    private static List<Boolean> makeRow() { // 한 줄의 사다리 생성
//        List<Boolean> row = new ArrayList<>();
//
//        int numberOfPlayers = 3;
//        boolean lastBridge = false;
//        for(int w = this.START_OF_BRIDGE; w<numberOfPlayers; w++) {
//            lastBridge = getRandomBrigde(lastBridge);
//            row.add(lastBridge); // 연결점 생성
//        }
//        return row;
//    }
//
//    private boolean getRandomBrigde(boolean lastBridge) {
//        // 중복 연결을 제거하기 위한 용도의 함수
//        return lastBridge ? false : randomStrategy.random();
//    }
}
