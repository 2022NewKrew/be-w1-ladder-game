package view;

import domain.data.LadderGameResult;
import view.data.UserInputInfo;
import view.screen.LadderBoardScreen;
import view.screen.LadderGameResultQueryScreen;
import view.screen.UserInputScreen;

public class LadderGameUI {

    private final UserInputScreen userInputScreen = new UserInputScreen();

    private final LadderBoardScreen ladderBoardScreen = new LadderBoardScreen();

    private final LadderGameResultQueryScreen ladderGameResultQueryScreen = new LadderGameResultQueryScreen();

    public UserInputInfo renderUserInputScreen() {
        return userInputScreen.render();
    }

    public void renderLadderBoard(LadderGameResult gameResult) {
        ladderBoardScreen.render(gameResult);
    }

    public void renderLadderGameResultQueryScreen(LadderGameResult gameResult) {
        ladderGameResultQueryScreen.render(gameResult);
    }

}
