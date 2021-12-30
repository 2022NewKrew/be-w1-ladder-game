package com.gunyoung.one.boot;

import com.gunyoung.one.ladder.Ladder;
import com.gunyoung.one.messages.GameMessage;
import com.gunyoung.one.view.View;

public class GameStarter {


    private static GameStarter INSTANCE;

    private GameStarter() {
    }

    public static GameStarter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GameStarter();
        return INSTANCE;
    }

    private final View view = new View();

    public void start() {
        inputDataForLadder();
        drawGameResult();
    }

    private void inputDataForLadder() {
        String userNames = inputUserNames();
        int ladderHeight = inputLadderHeight();
        Ladder.init(userNames, ladderHeight);
    }

    private String inputUserNames() {
        return view.inputStringWithMessage(GameMessage.INPUT_USER_NAME_MESSAGE);
    }

    private int inputLadderHeight() {
        return view.inputIntWithMessage(GameMessage.INPUT_LADDER_HEIGHT_MESSAGE);
    }

    private void drawGameResult() {
        ShapeMaker shapeMaker = new ShapeMaker(Ladder.getInstance());
        String gameResult = shapeMaker.getShapeOfGameResult();
        view.output(gameResult);
    }
}
