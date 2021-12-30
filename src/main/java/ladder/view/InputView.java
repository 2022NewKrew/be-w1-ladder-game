package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 얼마인가요";
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final int MAX_NAME_LENGTH = 5;
    private static final Scanner in = new Scanner(System.in);

    /**
     * 입력이 올바른지 확인하는 메서드
     *
     * @param input 입력받은 인자를 받는다
     * @throws InputMismatchException 양수가 아니면 예외를 던진다
     */
    private static void validateHeight(int input) throws InputMismatchException {
        if (input <= 0)
            throw new InputMismatchException();
    }

    /**
     * 사다리 높이를 입력 받는 메서드
     *
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    public static int inputHeight() throws InputMismatchException {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);

        int height = in.nextInt();
        validateHeight(height);
        return height;
    }

    private static void validateName(String name) throws InputMismatchException {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH)
            throw new InputMismatchException();
    }

    public static ArrayList<String> inputName() throws InputMismatchException {
        System.out.println(NAME_INPUT_MESSAGE);

        String input = in.nextLine();
        String[] names = input.split(",");
        for (String name: names) {
            validateName(name);
        }
        return new ArrayList<>(Arrays.asList(names));
    }
}
