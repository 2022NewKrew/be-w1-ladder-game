package com.gunyoung.one.boot;

import com.gunyoung.one.ladder.Ladder;
import com.gunyoung.one.view.View;

public class GameStarter {

    /**
     * for Singleton
     */
    private static GameStarter INSTANCE;

    private GameStarter() {}

    public static GameStarter getInstance() {
        if(INSTANCE == null)
            INSTANCE = new GameStarter();
        return INSTANCE;
    }

    private final View view = new View();

    /**
     * 게임을 시작한다
     */
    public void start() {
        inputDataForLadder();
        drawLadder();
    }

    private void inputDataForLadder() {
        int numOfUser = inputNumberOfUser();
        int ladderHeight = inputLadderHeight();
        Ladder.init(numOfUser, ladderHeight);
    }

    private int inputNumberOfUser() {
        return view.inputIntWithMessage("참여할 사람은 몇 명인가요?");
    }

    private int inputLadderHeight() {
        return view.inputIntWithMessage("최대 사다리 높이는 몇 개인가요?");
    }

    private void drawLadder() {
        String ladderFeature = Ladder.getInstance().getShapeOfLadder();
        view.output(ladderFeature);
    }
}
