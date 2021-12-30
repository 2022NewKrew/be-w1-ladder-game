package com.kakao;

import com.kakao.LadderGame.LadderGame;
import com.kakao.random.RandomStrategy;
import com.kakao.random.RandomStrategyOfBoolean;

public class Main {
    public static void main(String[] args) {
        RandomStrategy<Boolean> randomStrategy = new RandomStrategyOfBoolean();

        LadderGame ladderGame = new LadderGame();
        ladderGame.play(randomStrategy);
    }
}
