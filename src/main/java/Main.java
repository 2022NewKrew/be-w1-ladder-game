import configuration.LadderGameConfiguration;
import configuration.LadderHeight;
import configuration.PeopleCount;
import configuration.Player;
import service.LadderGameService;
import service.LadderGenerator;
import service.LadderRandomGenerator;
import ui.LadderGameUI;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // 1. 사용자로부터 게임 설정 입력 받기
            LadderGameUI ladderGameUI = new LadderGameUI();
            List<Player> peopleList = ladderGameUI.getPeopleList();
            LadderHeight maxLadderHeight = ladderGameUI.getMaxLadderHeight();

            // 2. 입력 받은 설정을 기반으로 사다리게임 서비스 만들기
            LadderGameService ladderGameService = makeLadderGameService(peopleList, maxLadderHeight);

            // 3. 사다리 게임 시작
            ladderGameService.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }

    private static LadderGameService makeLadderGameService(List<Player> playerList, LadderHeight maxLadderHeight) {
        LadderGameConfiguration ladderGameConfiguration = new LadderGameConfiguration(playerList, maxLadderHeight);
        LadderGenerator ladderGenerator = new LadderRandomGenerator();
        return new LadderGameService(ladderGameConfiguration, ladderGenerator);
    }

}