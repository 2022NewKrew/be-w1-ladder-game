package com.kakao.model;

public class GameRewards {
    String[] rewards;

    // 생성자
    public GameRewards(String[] rewards) {
        this.rewards = rewards;
    }

    // Getter
    public String[] getRewards() {
        return rewards;
    }
    public int getNumberOfRewards() { // 입력된 리워드 수를 반환
        return rewards != null ? rewards.length : 0;
    }
}
