package com.kakao.LadderGame;

import com.kakao.model.GamePlayers;
import com.kakao.model.GameRewards;
import com.kakao.model.Ladder;
import com.kakao.data.LadderChar;
import com.kakao.data.LadderOption;
import com.kakao.exception.IntegerFormatException;
import com.kakao.exception.PlayerFormatException;
import com.kakao.exception.RewardFormatException;
import com.kakao.random.RandomStrategy;

import java.io.*;
import java.util.List;

public class LadderIO {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static Ladder inputLadderData (RandomStrategy<Boolean> randomStrategy) {
        GamePlayers gamePlayers = null;
        GameRewards gameRewards = null;
        Integer ladderHeight = null;

        while(gamePlayers == null) { // 정상 입력을 할 때까지 반복
            gamePlayers = inputGamePlayers();
        }
        while(gameRewards == null) {
            gameRewards = inputGameRewards(gamePlayers.getNumberOfPlayers());
        }
        while(ladderHeight == null) {
            ladderHeight = inputLadderHeight();
        }

        return new Ladder(gamePlayers, gameRewards, ladderHeight, randomStrategy);
    }

    // 입력함수
    private static GamePlayers inputGamePlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            String[] gamePlayers = br.readLine().split(",");
            checkFormatOfPlayers(gamePlayers);
            return new GamePlayers(gamePlayers);
        } catch (IOException | PlayerFormatException e) { // 에러 출력
            e.printStackTrace();
            return null;
        }
    }
    private static GameRewards inputGameRewards(int numberOfPlayers) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        try {
            String[] gameRewards = br.readLine().split(",");
            checkFormatOfRewards(gameRewards, numberOfPlayers);
            return new GameRewards(gameRewards);
        } catch (IOException | RewardFormatException e){
            e.printStackTrace();
            return null;
        }
    }
    private static Integer inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            Integer inputData = Integer.parseInt(br.readLine());
            checkFormatOfInteger(inputData);
            return inputData;
        } catch (IOException | NumberFormatException | IntegerFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 검사 함수
    private static void checkFormatOfPlayers(String[] data) throws PlayerFormatException {
        for(String player : data) {
            checkFormatOfPlayer(player);
        }
    }
    private static void checkFormatOfPlayer(String data) throws PlayerFormatException {
        if(data.length() > LadderOption.MAX_PLAYER_NAME_LENGTH){
            throw new PlayerFormatException();
        }
    }
    private static void checkFormatOfInteger(Integer data) throws IntegerFormatException {
        if( data < 1 ) {
            throw new IntegerFormatException();
        }
    }
    private static void checkFormatOfRewards(String[] data, int arrayLength) throws RewardFormatException {
        if(data.length != arrayLength) {
            throw new RewardFormatException();
        }
        for(String reward: data) {
            checkFormatOfReward(reward);
        }
    }
    private static void checkFormatOfReward(String data) throws RewardFormatException {
        if(data.length() > LadderOption.MAX_REWARD_NAME_LENGTH){
            throw new RewardFormatException();
        }
    }

    // 출력함수
    public static void printLadder(Ladder ladder) {
        // 사다리 전체 출력
        StringBuilder sb = new StringBuilder();
        String[] gamePlayers = ladder.getGamePlayers();
        String[] gameRewards = ladder.getGameRewards();
        List<List<Boolean>> bridgeOfLadder = ladder.getBridgeOfLadder();

        printContents(sb, gamePlayers);
        for(List<Boolean> row: bridgeOfLadder){ // 높이
            printRow(sb, row); // 한 줄을 출력
        }
        printContents(sb, gameRewards);

        try { // 실제 버퍼로 출력 시도
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printRow(StringBuilder sb, List<Boolean> row) { // 한 줄 출력
        // 줄맞춤 용 사다리 공백
        String ladderPrefix = LadderChar.makeRepeatString(LadderChar.LADDER_PREFIX, LadderOption.LADDER_PREFIX_SPACE);
        sb.append(ladderPrefix);

        // 사다리 구성
        sb.append(LadderChar.LADDER_PILLAR); // 첫 막대기
        for(Boolean isBridge: row){ // 너비
            // 중간다리 판단
            String edgeString = isBridge ? LadderChar.LADDER_BRIDGE : LadderChar.LADDER_SPACE; // 문자 선택
            String edgeRepeat = LadderChar.makeRepeatString(edgeString, LadderOption.MAX_PLAYER_NAME_LENGTH); // 길이만큼 반복
            sb.append(edgeRepeat);
            sb.append(LadderChar.LADDER_PILLAR);
        }
        sb.append(LadderChar.LADDER_NEWLINE); // 줄바꿈
    }
    private static void printContents(StringBuilder sb, String[] gamePlayers) {
        // 참여자 이름 출력
        for(String player: gamePlayers) {
            sb.append(String.format("%"+LadderOption.MAX_PLAYER_NAME_LENGTH+"s ",player));
        }
        sb.append(LadderChar.LADDER_NEWLINE);
    }
}
