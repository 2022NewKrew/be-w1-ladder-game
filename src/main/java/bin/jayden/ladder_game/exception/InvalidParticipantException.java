package bin.jayden.ladder_game.exception;

public class InvalidParticipantException extends Exception {
    public InvalidParticipantException() {
        super("존재하지 않는 사용자");
    }
}
