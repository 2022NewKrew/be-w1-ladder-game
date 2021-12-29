package rubam.step3;

import java.util.*;

public class InputLadderInform {

    private static final int MAX_LENGTH = 5;
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇인가요?";
    private static final String LADDER_INPUT_NAME_SIZE_ERROR_MESSAGE = "이내의 크기로 입력해주세요.";
    private static final String LADDER_INPUT_HEIGHT_ERROR_MESSAGE = "최소 1 이상의 높이로 지정해주세요.";
    private static final String INPUT_MISMATCH_EXCEPTION_ERROR_MESSAGE = "숫자로 입력해주세요.";
    private static final String SPLIT_POINT = ",";

    private InputLadderInform() {

    }

    ////////////////////////////////////

    public static List<String> inputNames() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(NAME_INPUT_MESSAGE);
                String names = scanner.nextLine();
                checkNames(names);
                return new ArrayList<>(Arrays.asList(names.split(SPLIT_POINT)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Integer inputHeight() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(HEIGHT_INPUT_MESSAGE);
                int height = scanner.nextInt();
                checkHeight(height);
                return height;
            } catch (LadderInputException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException ime) {
                System.out.println(INPUT_MISMATCH_EXCEPTION_ERROR_MESSAGE);
            }
        }
    }

    ////////////////////////////////////

    private static void checkHeight(int height) throws LadderInputException {
        if (height < 1) {
            throw new LadderInputException(LADDER_INPUT_HEIGHT_ERROR_MESSAGE);
        }
    }

    private static void checkNames(String names) {
        for (String i : names.split(",")) {
            checkNameSize(i);
        }
    }

    private static void checkNameSize(String i) throws LadderInputException {
        if (i.length() > MAX_LENGTH) {
            throw new LadderInputException(MAX_LENGTH + LADDER_INPUT_NAME_SIZE_ERROR_MESSAGE);
        }
    }
}
