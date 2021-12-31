package bin.jayden.ladder_game.domain;

public class Constants {
    public final static int MIN_PARTICIPANT_SIZE = 2;
    public final static int MAX_NAME_SIZE = 5;
    public final static int MIN_LADDER_HEIGHT = 1;
    public final static int PREFIX_SIZE = (MAX_NAME_SIZE + 1) / 2; // 사디리를 출력할때 이름과 위치를 맞추기 위해 출력하는 빈칸 수
    public final static String PARTICIPANT_DELIMITER = ",";
    public final static String PARTICIPANT_DELIMITER_NAME = "쉼표";
    public final static String RESULT_DELIMITER = ",";
    public final static String RESULT_DELIMITER_NAME = "쉼표";
    public final static String CONSECUTIVE_VALUE = "11"; // List<LadderRow>를 스트링으로 변환한 값에 11이 존재한다는건 연속된 줄이 존재한다는 의미
    public final static char LADDER_LINE_CHARACTER = '-';
    public final static char LADDER_EMPTY_CHARACTER = ' ';
    public final static char LADDER_SEPARATION_CHARACTER = '|';

    public final static String INVALID_PARTICIPANT_MESSAGE = "존재하지 않는 사용자";
    public final static String INVALID_RESULT_SIZE_MESSAGE = "참가자 수와 결과의 개수가 같지않습니다.";
    public final static String INVALID_PARTICIPANTS_SIZE_MESSAGE = String.format("잘못된 크기의 참가자 수 입니다. (최소 : %d)", Constants.MIN_PARTICIPANT_SIZE);
    public final static String INVALID_NAME_SIZE_MESSAGE = String.format("잘못된 크기의 이름을 가진 참가자가 존재합니다. (최대 : %d)", Constants.MAX_NAME_SIZE);
    public final static String INVALID_LADDER_HEIGHT_MESSAGE = String.format("잘못된 크기의 사다리 높이입니다. (최소 : %d)", Constants.MIN_LADDER_HEIGHT);

}
