package com.gunyoung.one.boot;

import com.gunyoung.one.ladder.Ladder;
import com.gunyoung.one.view.View;

public class GameStarter {

    /**
     * for Singleton
     */
    private static GameStarter INSTANCE;

    private GameStarter() {
    }

    public static GameStarter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GameStarter();
        return INSTANCE;
    }

    private final View view = new View();
    private final ShapeMaker shapeMaker = new ShapeMaker();

    /**
     * 게임을 시작한다
     */
    public void start() {
        inputDataForGame();
        drawGameResult();
    }

    private void inputDataForGame() {
        String userNames = inputUserNames();
        int ladderHeight = inputLadderHeight();
        Ladder.init(userNames, ladderHeight);
    }

    private String inputUserNames() {
        return view.inputStringWithMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private int inputNumberOfUser() {
        return view.inputIntWithMessage("참여할 사람은 몇 명인가요?");
    }

    private int inputLadderHeight() {
        return view.inputIntWithMessage("최대 사다리 높이는 몇 개인가요?");
    }

    private void drawGameResult() {
        String gameResult = shapeMaker.getShapeOfGameResult();
        view.output(gameResult);
    }
}
