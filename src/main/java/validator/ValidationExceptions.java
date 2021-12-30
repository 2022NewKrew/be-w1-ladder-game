package validator;

import domain.Player;
import validator.Player.LengthOfPlayerName;

public class ValidationExceptions {
    private static final int MAXIMUM_PLAYER_NAME_LENGTH = 5;

    public static void validatePlayerName(Player player) {
        if (player.getName().length() > MAXIMUM_PLAYER_NAME_LENGTH) {
            throw new LengthOfPlayerName();
        }
    }

}
