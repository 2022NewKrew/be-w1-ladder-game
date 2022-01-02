package validator.Player;

public class LengthOfPlayerNameException extends RuntimeException {
    private static final String LENGTH_OF_PLAYER_NAME = "Player 이름을 5글자 이내로 입력해주세요";

    public LengthOfPlayerNameException() {
        super(LENGTH_OF_PLAYER_NAME);
    }
}

