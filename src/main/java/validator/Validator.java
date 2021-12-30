package validator;

import service.LadderSizeConfig;

import java.util.List;
import java.util.Set;

public class Validator {
    public static void checkPositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkGameResultsLength(List<String> gameResults){
        gameResults.forEach(Validator::checkGameResultsLengthUnderMaxGameResultsLength);
    }

    public static void checkNameLength(List<String> participantsNames) {
        participantsNames.forEach(Validator::checkNameLengthUnderMaxNameLength);
    }

    private static void checkNameLengthUnderMaxNameLength(String name) {
        if (name.length() > LadderSizeConfig.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkGameResultsLengthUnderMaxGameResultsLength(String gameResult){
        if (gameResult.length() > LadderSizeConfig.MAX_GAME_RESULT_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    public static void checkParticipantsNameSizeAndGameResultsSize(int numberOfParticipants, int numberOfGameResults) {
        if (numberOfParticipants != numberOfGameResults){
            throw new IllegalArgumentException();
        }
    }

    public static void containsName(String name, Set<String> participantsNames) {
        if (!participantsNames.contains(name) && !name.equals("춘식이") && !name.equals("all")){
            throw new IllegalArgumentException();
        }
    }
}
