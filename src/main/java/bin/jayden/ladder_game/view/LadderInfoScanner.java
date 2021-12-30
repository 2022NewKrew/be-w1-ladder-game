package bin.jayden.ladder_game.view;

import bin.jayden.ladder_game.domain.Constants;
import bin.jayden.ladder_game.domain.LadderInfo;

import java.util.Scanner;

public class LadderInfoScanner {
    private static final Scanner scanner = new Scanner(System.in);

    private LadderInfoScanner() {
        //instance 생성 제한용 생성자
    }

    public static LadderInfo getLadderInfo() {
        try {
            String[] participants = getParticipants();
            int height = getHeight();
            return new LadderInfo(participants, height);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("사다리의 높이는 숫자로 입력해주세요.");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    private static String[] getParticipants() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)\n", Constants.DELIMITER_NAME, Constants.DELIMITER);
        String inputString = scanner.nextLine();
        return inputString.split(Constants.DELIMITER);
    }

    private static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
