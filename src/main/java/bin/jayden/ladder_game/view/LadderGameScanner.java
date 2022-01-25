package bin.jayden.ladder_game.view;

import bin.jayden.ladder_game.domain.Constants;
import bin.jayden.ladder_game.domain.LadderGameInfo;
import bin.jayden.ladder_game.exception.InvalidLadderHeightException;
import bin.jayden.ladder_game.exception.InvalidNameSizeException;
import bin.jayden.ladder_game.exception.InvalidParticipantsSizeException;
import bin.jayden.ladder_game.exception.InvalidResultSizeException;

import java.util.Scanner;


public class LadderGameScanner {
    static final Scanner scanner = new Scanner(System.in);

    private LadderGameScanner() {
        // instance 생성 제한용 생성자
    }

    public static LadderGameInfo getLadderInfo() {
        String[] participants = getParticipants();
        String[] results = getResults(participants.length);
        while (true) {
            try {
                int height = getHeight();
                return new LadderGameInfo(participants, results, height);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("사다리의 높이는 숫자로 입력해주세요.");
            } catch (InvalidParticipantsSizeException | InvalidLadderHeightException | InvalidResultSizeException | InvalidNameSizeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }


    private static String[] getParticipants() {
        String[] participants = null;
        while (participants == null) {
            participants = getStringArray(Constants.INPUT_PARTICIPANTS_MESSAGE, strings -> {
                if (strings.length < Constants.MIN_PARTICIPANT_SIZE)
                    throw new InvalidParticipantsSizeException(Constants.INVALID_PARTICIPANTS_SIZE_MESSAGE);

                for (String participant : strings) {
                    checkParticipantNameSize(participant);
                }
            });
        }
        return participants;
    }


    private static void checkParticipantNameSize(String participant) throws InvalidNameSizeException {
        if (participant.isEmpty() || participant.length() > Constants.MAX_NAME_SIZE)
            throw new InvalidNameSizeException(Constants.INVALID_NAME_SIZE_MESSAGE);
    }

    private static String[] getResults(int participantsLength) {
        String[] results = null;
        while (results == null) {
            results = getStringArray(Constants.INPUT_RESULTS_MESSAGE, strings -> {
                if (participantsLength != strings.length)
                    throw new InvalidResultSizeException(Constants.INVALID_RESULT_SIZE_MESSAGE);
            });
        }
        return results;
    }

    private static String[] getStringArray(String message, StringArrayValidator validator) {
        System.out.print(message);
        String inputString = scanner.nextLine();
        String[] results = inputString.split(Constants.RESULT_DELIMITER);
        try {
            validator.valid(results);
        } catch (InvalidNameSizeException | InvalidParticipantsSizeException | InvalidResultSizeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
        return results;
    }

    private static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static String getName() {
        return scanner.nextLine();
    }

    @FunctionalInterface
    private interface StringArrayValidator {
        void valid(String[] strings);
    }
}
