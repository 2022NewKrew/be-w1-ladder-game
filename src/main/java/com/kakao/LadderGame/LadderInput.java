package com.kakao.LadderGame;

import com.kakao.exception.IntegerFormatException;
import com.kakao.exception.PlayerFormatException;
import com.kakao.exception.RewardFormatException;
import com.kakao.model.GamePlayers;
import com.kakao.model.GameRewards;
import com.kakao.model.Ladder;
import com.kakao.random.RandomStrategy;
import com.kakao.util.TextUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderInput {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            String[] gamePlayers = TextUtil.makeSplitStringArray(br.readLine(), ",");
            return new GamePlayers(gamePlayers);
        } catch (IOException | PlayerFormatException e) { // 에러 출력
            e.printStackTrace();
            return null;
        }
    }
    private static GameRewards inputGameRewards(int numberOfPlayers) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        try {
            String[] gameRewards = TextUtil.makeSplitStringArray(br.readLine(), ",");
            return new GameRewards(gameRewards, numberOfPlayers);
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
    private static void checkFormatOfInteger(Integer data) throws IntegerFormatException {
        if( data < 1 ) {
            throw new IntegerFormatException();
        }
    }
}
