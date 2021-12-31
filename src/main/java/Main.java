import configuration.*;
import domain.data.LadderGameResult;
import domain.LadderGameService;
import domain.LadderGenerator;
import domain.LadderRandomGenerator;
import view.LadderGameUI;
import view.data.UserInputInfo;

public class Main {

    private static final LadderGameUI ladderGameUI = new LadderGameUI();

    public static void main(String[] args) {
        try {
            Main.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * 1. 사용자로부터 게임 설정 입력 받기
     * 2. 사용자 입력을 기반으로 사다리게임 서비스 만들기
     * 3. 사다리 게임 시작
     * 4. 사다리 결과 출력
     */
    private static void start() {
        UserInputInfo userInputInfo = ladderGameUI.renderUserInputScreen();

        LadderGameService ladderGameService = makeLadderGameService(userInputInfo);
        LadderGameResult gameResult = ladderGameService.start();

        ladderGameUI.renderLadderBoard(gameResult);

        ladderGameUI.renderLadderGameResultQueryScreen(gameResult);
    }

    private static LadderGameService makeLadderGameService(UserInputInfo userInputInfo) {
        LadderGameConfiguration ladderGameConfiguration = makeLadderGameConfiguration(userInputInfo);
        LadderGenerator ladderGenerator = new LadderRandomGenerator();
        return new LadderGameService(ladderGameConfiguration, ladderGenerator);
    }

    private static LadderGameConfiguration makeLadderGameConfiguration(UserInputInfo userInputInfo) {
        return new LadderGameConfiguration(
                userInputInfo.getPlayers(),
                userInputInfo.getLadderResults(),
                userInputInfo.getMaxLadderHeight()
        );
    }

}