package view;

import domain.data.GameResult;
import view.data.UserInputInfo;
import view.screen.LadderBoardScreen;
import view.screen.UserInputScreen;

public class LadderGameUI {

    private final UserInputScreen userInputScreen = new UserInputScreen();

    private final LadderBoardScreen ladderBoardScreen = new LadderBoardScreen();

    public UserInputInfo renderUserInputScreen() {
        return userInputScreen.render();
    }

    public void renderLadderBoard(GameResult gameResult) {
        ladderBoardScreen.render(gameResult);
    }
}
