package ladder.domain.exception;

public class LadderException extends Exception {

    private Object errorParameter = "";
    private ErrorCode errorCode = ErrorCode.OK;

    public LadderException() {
    }

    public LadderException(String message) {
        super(message);
    }

    public LadderException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public LadderException(ErrorCode errorCode, Object errorParameter) {
        this.errorCode = errorCode;
        this.errorParameter = errorParameter;
    }

    public String getErrorMessage() {
        switch (errorCode) {
            case OK:
                return null;
            case INVALID_HEIGHT:
                return String.format("'%s'는 부적절한 사다리 높이입니다.", errorParameter);
            case EMPTY_PARTICIPANTS:
                return "사다리 게임 참여자가 아무도 없습니다.";
            case EXCEED_MAX_PARTICIPANT_NAME:
                return String.format("'%s' 사다리 게임 참여자의 이름 최대 길이를 초과했습니다.", errorParameter);
            case EMPTY_PARTICIPANT_NAME:
                return "사다리 게임 참여자의 이름은 공백일 수 없습니다.";
        }
        return "";
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public enum ErrorCode {
        OK, INVALID_HEIGHT, EMPTY_PARTICIPANTS, EMPTY_PARTICIPANT_NAME, EXCEED_MAX_PARTICIPANT_NAME
    }

}
