package ladder.view;

import java.util.Map;
import static ladder.view.InputUtil.inputName;

public class OutputUtil {

    private static final String SEPARATER = "-".repeat(25) + "\n";
    private static final String LADDER_HEIGHT_INPUT_STRING_FIRST = SEPARATER + "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_HEIGHT_INPUT_STRING_AGAIN = SEPARATER + "최대 사다리 높이를 다시 입력해주세요. (사다리 높이는 양의 정수만 입력 가능합니다.)";
    private static final String PERSON_INPUT_STRING_FIRST = SEPARATER + "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PERSON_INPUT_STRING_AGAIN =
            SEPARATER +
            "아래의 사항들을 만족하도록 참여할 사람의 이름을 다시 입력해주세요.\n" +
            "1. 이름은 쉼표(,)로 구분하세요.\n" +
            "2. 최소 두 명 이상의 이름을 입력해주세요.\n" +
            "3. 이름은 알파벳 기준 최소 1글자에서 최대 5글자까지만 입력 가능합니다.";
    private static final String RESULT_INPUT_STRING_FIRST = SEPARATER + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String RESULT_INPUT_STRING_AGAIN =
            SEPARATER +
            "아래의 사항들을 만족하도록 실행 결과를 다시 입력하세요.\n" +
            "1. 실행 결과를 쉼표(,)로 구분하세요.\n" +
            "2. 결과의 개수는 참여 인원과 같아야 합니다.\n" +
            "3. 각각의 결과는 알파벳 기준 최소 1글자에서 최대 5글자까지만 입력 가능합니다.";
    private static final String QUESTION_STRING = SEPARATER + "결과를 보고 싶은 사람은?";
    private static final String RESULT_STRING = SEPARATER + "실행 결과";
    private static final String GAME_OVER_STRING = SEPARATER + "게임을 종료합니다.\n" + SEPARATER;

    public static void printInputPersonMsg(boolean again) {
        System.out.println(again ? PERSON_INPUT_STRING_AGAIN : PERSON_INPUT_STRING_FIRST);
    }

    public static void printInputLadderHeightMsg(boolean again) {
        System.out.println(again ? LADDER_HEIGHT_INPUT_STRING_AGAIN : LADDER_HEIGHT_INPUT_STRING_FIRST);
    }

    public static void printInputResultMsg(boolean again) {
        System.out.println(again ? RESULT_INPUT_STRING_AGAIN : RESULT_INPUT_STRING_FIRST);
    }

    public static void printSeparater() {
        System.out.println(SEPARATER);
    }

    public static void showResult(Map<String, String> results) {
        String name;
        boolean flag = true;
        while(flag) {
            System.out.println(QUESTION_STRING);
            name = inputName();
            flag = findResult(results, name);
        }
        System.out.println(GAME_OVER_STRING);
    }

    private static boolean findResult(Map<String, String> results, String name) {
        switch (name) {
            case "춘식이":
                return false;
            case "all":
                StringBuilder sb = new StringBuilder();
                results.keySet().stream().forEach(key -> sb.append(key + " : " + results.get(key)).append("\n"));
                System.out.println(sb);
                return true;
            default:
                System.out.println(results.getOrDefault(name, "참여하지 않은 사람의 이름입니다."));
                return true;
        }
    }
}
