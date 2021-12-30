package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static ladder.view.OutputUtil.*;

public class InputUtil {

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MIN_NUM_OF_PERSONS = 2;
    private static final int MAX_NAME_LENGTH = 5;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputLadderHeight(boolean again) {
        printInputLadderHeightMsg(again);
        int input = SCANNER.nextInt();
        SCANNER.nextLine(); // nextInt()로 인해 남은 입력 버퍼 비우기
        printSeparater();

        if(input < MIN_LADDER_HEIGHT) {
            return inputLadderHeight(true);
        }
        return input;
    }

    public static List<String> inputPersons(boolean again) {
        printInputPersonMsg(again);
        String inputText = SCANNER.nextLine();
        printSeparater();

        String[] persons = inputText.split(",");

        if(satisfiedPersons(persons)) {
            return Arrays.asList(persons);
        }

        return inputPersons(true);
    }

    public static List<String> inputResults(boolean again, int numOfPersons) {
        printInputResultMsg(again);
        String inputText = SCANNER.nextLine();
        printSeparater();
        
        String[] results = inputText.split(",");
        
        if(satisfiedResults(results, numOfPersons)) {
            return Arrays.asList(results);
        }

        return inputResults(true, numOfPersons);
    }

    private static boolean satisfiedResults(String[] results, int numOfPersons) {
        if(results.length != numOfPersons) {
            return false;
        }
        long notInRangeCnt = Arrays.stream(results)
                                                    .filter(e -> e.length() < 1 || e.length() > MAX_NAME_LENGTH)
                                                    .count();

        return notInRangeCnt == 0L;
    }

    private static boolean satisfiedPersons(String[] persons) {
        if(persons.length < MIN_NUM_OF_PERSONS) {
            return false;
        }
        long notInRangeCnt = Arrays.stream(persons)
                                                .filter(e -> e.length() < 1 || e.length() > MAX_NAME_LENGTH)
                                                .count();

        return notInRangeCnt == 0L;
    }

    public static String inputName() {
        return SCANNER.nextLine();
    }
}
