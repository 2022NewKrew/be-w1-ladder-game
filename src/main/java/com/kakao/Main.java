package com.kakao;

import com.kakao.LadderGame.LadderGame;
import com.kakao.model.RandomStrategy;
import com.kakao.model.RandomStrategyOfBoolean;

public class Main {
    public static void main(String[] args) {
        RandomStrategy<Boolean> randomStrategy = new RandomStrategyOfBoolean();

        LadderGame ladderGame = new LadderGame();
        ladderGame.play(randomStrategy);
    }
}
