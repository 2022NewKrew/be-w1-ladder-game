import configuration.*;
import common.data.GameResult;
import service.LadderGameService;
import service.LadderGenerator;
import service.LadderRandomGenerator;
import ui.LadderGameUI;
import ui.data.UserInputInfo;

public class Main {

    public static void main(String[] args) {
        try {
            Main.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void start() {

        // 1. 사용자로부터 게임 설정 입력 받기
        LadderGameUI ladderGameUI = new LadderGameUI();
        UserInputInfo userInputInfo = ladderGameUI.renderUserInputScreen();

        // 2. 사용자 입력을 기반으로 사다리게임 서비스 만들기
        LadderGameService ladderGameService = makeLadderGameService(userInputInfo);

        // 3. 사다리 게임 시작
        GameResult gameResult = ladderGameService.start();

        // 4. 사다리 결과 출력
        ladderGameUI.renderLadderBoard(gameResult);
    }

    private static LadderGameConfiguration makeLadderGameConfiguration(UserInputInfo userInputInfo) {
        return new LadderGameConfiguration(
                userInputInfo.getPlayerList(),
                userInputInfo.getMaxLadderHeight()
        );
    }

    private static LadderGameService makeLadderGameService(UserInputInfo userInputInfo) {
        LadderGameConfiguration ladderGameConfiguration = makeLadderGameConfiguration(userInputInfo);
        LadderGenerator ladderGenerator = new LadderRandomGenerator();
        return new LadderGameService(ladderGameConfiguration, ladderGenerator);
    }

}