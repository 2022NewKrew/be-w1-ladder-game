package validator;

import domain.Player;
import validator.Player.LengthOfPlayerNameException;

public class Validation {
    private static final int MAXIMUM_PLAYER_NAME_LENGTH = 5;
    private static final int MIMIMUM_PLAYER_NAME_LENGTH = 1;

    public static void validatePlayerName(String name) {
        if (name.length() > MAXIMUM_PLAYER_NAME_LENGTH || name.length() < MIMIMUM_PLAYER_NAME_LENGTH) {
            throw new LengthOfPlayerNameException();
        }
    }

}
