package ladder.domain;

import ladder.exception.InvalidHeight;
import ladder.exception.InvalidLadderResult;
import ladder.exception.InvalidName;
import ladder.message.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class Validation {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_LADDER_RESULT_LENGTH = 5;

    public static void validateHeight(int height) {
        condition(0 < height, new InvalidHeight(ErrorMessage.NEGATIVE_HEIGHT.getMessage()));
    }

    public static void validateLadderResults(ArrayList<String> ladderResults, int namesSize) {
        condition(!ladderResults.isEmpty(), new InvalidLadderResult(ErrorMessage.EMPTY_LADDER_RESULTS.getMessage()));
        condition(namesSize == ladderResults.size(), new InvalidLadderResult(ErrorMessage.NAME_AND_RESULT_SIZE_ARE_DIFFERENT.getMessage()));
        ladderResults.forEach(Validation::validateLadderResult);
    }

    private static void validateLadderResult(String ladderResult) {
        condition(!ladderResult.isEmpty(), new InvalidName(ErrorMessage.EMPTY_LADDER_RESULT.getMessage()));
        condition(ladderResult.length() <= MAX_LADDER_RESULT_LENGTH, new InvalidLadderResult(ErrorMessage.EXCEED_MAX_LADDER_RESULT.getMessage()));
    }

    public static void validateNames(ArrayList<String> names) {
        condition(!names.isEmpty(), new InvalidName(ErrorMessage.EMPTY_NAMES.getMessage()));
        names.forEach(name -> validateName(name, null));
    }

    public static void validateName(String name, HashMap<String, String> playerResults) {
        if (playerResults != null)
            condition(playerResults.containsKey(name), new InvalidName(ErrorMessage.PLAYER_NOT_EXIST.getMessage()));
        condition(!name.isEmpty(), new InvalidName(ErrorMessage.EMPTY_NAME.getMessage()));
        condition(name.length() <= MAX_NAME_LENGTH, new InvalidName(ErrorMessage.EXCEED_MAX_NAME.getMessage()));
    }

    private static void condition(boolean predicate, RuntimeException runtimeException) {
        if (!predicate)
            throw runtimeException;
    }
}
