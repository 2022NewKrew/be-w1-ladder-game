package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 얼마인가요";
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final Scanner in = new Scanner(System.in);

    /**
     * 사다리 높이를 입력 받는 메서드
     *
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    public static int inputHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);

        return in.nextInt();
    }

    /**
     * 이름을 입력받는 메서드
     * @return 이름을 저장하는 ArrayList를 반환한다
     */
    public static ArrayList<String> inputName() {
        System.out.println(NAME_INPUT_MESSAGE);

        String input = in.nextLine();
        String[] names = input.split(",");
        return new ArrayList<>(Arrays.asList(names));
    }
}
