package bin.jayden.ladder_game.view;

import bin.jayden.ladder_game.domain.Constants;
import bin.jayden.ladder_game.domain.LadderGame;
import bin.jayden.ladder_game.domain.LadderGameInfo;
import bin.jayden.ladder_game.exception.InvalidLadderHeightException;
import bin.jayden.ladder_game.exception.InvalidNameSizeException;
import bin.jayden.ladder_game.exception.InvalidParticipantsSizeException;
import bin.jayden.ladder_game.exception.InvalidResultSizeException;


public class LadderInfoScanner {

    private LadderInfoScanner() {
        // instance 생성 제한용 생성자
    }

    public static LadderGameInfo getLadderInfo() {
        String[] participants = getParticipants();
        String[] results = getResults();
        int height;
        try {
            height = getHeight();
        } catch (NumberFormatException numberFormatException) {
            System.out.println("사다리의 높이는 숫자로 입력해주세요.");
            return null;
        }
        try {
            return new LadderGameInfo(participants, results, height);
        } catch (InvalidParticipantsSizeException | InvalidLadderHeightException | InvalidResultSizeException | InvalidNameSizeException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    private static String[] getParticipants() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)\n", Constants.PARTICIPANT_DELIMITER_NAME, Constants.PARTICIPANT_DELIMITER);
        String inputString = LadderGame.scanner.nextLine();
        return inputString.split(Constants.PARTICIPANT_DELIMITER);
    }

    private static String[] getResults() {
        System.out.printf("실행 결과를 입력하세요. (결과는 %s(%s)로 구분하세요)\n", Constants.RESULT_DELIMITER_NAME, Constants.RESULT_DELIMITER);
        String inputString = LadderGame.scanner.nextLine();
        return inputString.split(Constants.RESULT_DELIMITER);
    }

    private static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = LadderGame.scanner.nextLine();
        return Integer.parseInt(input);
    }
}
