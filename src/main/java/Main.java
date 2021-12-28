import configuration.LadderGameConfiguration;
import configuration.LadderHeight;
import configuration.PeopleCount;
import service.LadderGameService;
import service.LadderGenerator;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try{
            // 1. 사용자로부터 게임 설정 입력 받기
            int numberOfMan = getUserInputInt("참여할 사람은 몇 명인가요?");
            PeopleCount peopleCount = new PeopleCount(numberOfMan);

            int maxHeightOfLadder = getUserInputInt("최대 사다리 높이는 몇 개인가요?");
            LadderHeight maxLadderHeight = new LadderHeight(maxHeightOfLadder);

            // 2. 입력 받은 설정을 기반으로 사다리게임 초기화하기
            LadderGameService ladderGameService = makeLadderGameService(peopleCount, maxLadderHeight);

            // 3. 사다리 게임 시작
            ladderGameService.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }

    public static LadderGameService makeLadderGameService(PeopleCount peopleCount, LadderHeight maxLadderHeight) {
        LadderGameConfiguration ladderGameConfiguration = new LadderGameConfiguration(peopleCount, maxLadderHeight);
        LadderGenerator ladderGenerator = new LadderGenerator();
        return new LadderGameService(ladderGameConfiguration, ladderGenerator);
    }

    public static int getUserInputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}