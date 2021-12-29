package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtil {

    private static final String SEPARATER = "-".repeat(25) + "\n";
    private static final String LADDER_HEIGHT_INPUT_STRING_FIRST = SEPARATER + "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_HEIGHT_INPUT_STRING_AGAIN = SEPARATER + "최대 사다리 높이를 다시 입력해주세요.";
    private static final String PERSON_INPUT_STRING_FIRST = SEPARATER + "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PERSON_INPUT_STRING_AGAIN =
                    SEPARATER +
                    "아래의 사항들을 만족하도록 참여할 사람의 이름을 다시 입력해주세요.\n" +
                    "1. 이름은 쉼표(,)로 구분하세요.\n" +
                    "2. 최소 두 명 이상의 이름을 입력해주세요.\n" +
                    "3. 이름은 알파벳 기준 최소 1글자에서 최대 5글자까지만 입력 가능합니다.";

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MIN_NUM_OF_PERSONS = 2;
    private static final int MAX_NAME_LENGTH = 5;

    private static final Scanner SCANNER = new Scanner(System.in);

    // 사다리 높이를 입력받는 메서드, 양의 정수만을 입력받도록 처리하는 것이 필요할 것 같다.
    public static int inputLadderHeight(boolean again) {
        System.out.println(again ? LADDER_HEIGHT_INPUT_STRING_AGAIN : LADDER_HEIGHT_INPUT_STRING_FIRST);
        int input = SCANNER.nextInt();
        System.out.println(SEPARATER);

        if(input < MIN_LADDER_HEIGHT) {
            return inputLadderHeight(true);
        }
        return input;
    }

    // 참여하는 사람들의 이름을 입력받는 메서드, 인원이 최소 2명이며 각 이름을 5자 이내로 입력받도록 처리하는 것이 필요할 것 같다.
    public static List<String> inputPersons(boolean again) {
        System.out.println(again ? PERSON_INPUT_STRING_AGAIN : PERSON_INPUT_STRING_FIRST);
        String inputText = SCANNER.nextLine();
        System.out.println(SEPARATER);

        String[] persons = inputText.split(",");

        if(satisfiedPersons(persons)) {
            return Arrays.asList(persons);
        }

        return inputPersons(true);
    }

    private static boolean satisfiedPersons(String[] persons) {
        if(persons.length < MIN_NUM_OF_PERSONS) {
            return false;
        }
        long exceedCnt = Arrays.stream(persons)
                                                .filter(e -> e.length() < 1 || e.length() > MAX_NAME_LENGTH)
                                                .count();

        return exceedCnt <= 0L;
    }
}
