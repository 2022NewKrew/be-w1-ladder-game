package bin.jayden.ladder_game.domain;

public class Constants {
    public final static int MIN_PARTICIPANT_SIZE = 2;
    public final static int MAX_PARTICIPANT_SIZE = Integer.MAX_VALUE - 1;
    public final static int MAX_NAME_SIZE = 5;
    public final static int MIN_NAME_SIZE = 1;
    public final static int MAX_LADDER_HEIGHT = Integer.MAX_VALUE - 1;
    public final static int MIN_LADDER_HEIGHT = 1;
    public final static int PREFIX_SIZE = (MAX_NAME_SIZE + 1) / 2; //사디리를 출력할때 이름과 위치를 맞추기 위해 출력하는 빈칸 수
    public final static String PARTICIPANT_DELIMITER = ",";
    public final static String PARTICIPANT_DELIMITER_NAME = "쉼표";
    public final static String RESULT_DELIMITER = ",";
    public final static String RESULT_DELIMITER_NAME = "쉼표";
    public final static String CONSECUTIVE_VALUE = "11";//List<LadderRow>를 스트링으로 변환한 값에 11이 존재한다는건 연속된 줄이 존재한다는 의미
    public final static char LADDER_LINE_CHARACTER = '-';
    public final static char LADDER_EMPTY_CHARACTER = ' ';
    public final static char LADDER_SEPARATION_CHARACTER = '|';
}
