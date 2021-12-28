import configuration.LadderGameConfiguration;
import service.LadderGameService;
import service.LadderGenerator;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 사용자로부터 게임 설정 입력 받기
        int numberOfMan = 0, maxHeightOfLadder = 0;
        try {
            numberOfMan = getUserInputInt("참여할 사람은 몇 명인가요?");
            maxHeightOfLadder = getUserInputInt("최대 사다리 높이는 몇 개인가요?");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 2. 입력 받은 설정을 기반으로 사다리게임 초기화하기
        LadderGameConfiguration ladderGameConfiguration = new LadderGameConfiguration(numberOfMan, maxHeightOfLadder);
        LadderGenerator ladderGenerator = new LadderGenerator();
        LadderGameService ladderGameService = new LadderGameService(ladderGameConfiguration, ladderGenerator);

        // 3. 사다리 게임 시작
        ladderGameService.start();
    }

    public static int getUserInputInt(String message) throws Exception {
        System.out.println(message);
        int ret = scanner.nextInt();
        if(isNegativeValue(ret)) {
            throw new Exception("양수를 입력해주세요.");
        }
        return ret;
    }

    public static boolean isNegativeValue(int num) {
        return num < 0;
    }

}