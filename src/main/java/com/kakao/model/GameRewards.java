package com.kakao.model;

import com.kakao.data.LadderOption;
import com.kakao.exception.RewardFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 보상 정보
public class GameRewards {
    List<String> rewards;

    // 생성자
    public GameRewards(String[] rewards, int arrayLength) throws RewardFormatException {
        checkFormatOfRewards(rewards, arrayLength);
        this.rewards = new ArrayList<>(Arrays.asList(rewards));
    }

    // Getter
    public String[] getRewards() {
        String[] returnData = new String[rewards.size()];
        rewards.toArray(returnData);
        return returnData;
    }
    public int getNumberOfRewards() { // 입력된 리워드 수를 반환
        return rewards != null ? rewards.size() : 0;
    }

    // 검사 함수
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
}
