package bin.jayden.ladder_game.domain;

import java.util.ResourceBundle;

public class Constants {
    public final static ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle");
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

    public final static String INVALID_PARTICIPANT_MESSAGE = getI18NString("INVALID_PARTICIPANT_MESSAGE");
    public final static String INVALID_RESULT_SIZE_MESSAGE = getI18NString("INVALID_RESULT_SIZE_MESSAGE");
    public final static String INVALID_PARTICIPANTS_SIZE_MESSAGE = String.format(getI18NString("INVALID_PARTICIPANTS_SIZE_MESSAGE"), Constants.MIN_PARTICIPANT_SIZE);
    public final static String INVALID_NAME_SIZE_MESSAGE = String.format(getI18NString("INVALID_NAME_SIZE_MESSAGE"), Constants.MAX_NAME_SIZE);
    public final static String INVALID_LADDER_HEIGHT_MESSAGE = String.format(getI18NString("INVALID_LADDER_HEIGHT_MESSAGE"), Constants.MIN_LADDER_HEIGHT);


    public final static String INPUT_PARTICIPANTS_MESSAGE = String.format("참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)\n", Constants.PARTICIPANT_DELIMITER_NAME, Constants.PARTICIPANT_DELIMITER);
    public final static String INPUT_RESULTS_MESSAGE = String.format("실행 결과를 입력하세요. (결과는 %s(%s)로 구분하세요)\n", Constants.RESULT_DELIMITER_NAME, Constants.RESULT_DELIMITER);

    public static String getI18NString(String key) {
        return bundle.getString(key);
    }
}
