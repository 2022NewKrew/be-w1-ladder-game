package ladder.view;

import ladder.message.GameMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    /**
     * 사다리 높이를 입력 받는 메서드
     *
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    public static int inputHeight() {
        System.out.println(GameMessage.LADDER_HEIGHT_INPUT.getMessage());
        return in.nextInt();
    }

    /**
     * 사다리 결과를 입력받는 메서드
     *
     * @return 사다리 결과를 저장하는 ArrayList를 반환한다
     */
    public static ArrayList<String> inputLadderResult() {
        System.out.println(GameMessage.RESULT_INPUT.getMessage());

        String input = in.nextLine();
        String[] result = input.split(",");
        return new ArrayList<>(Arrays.asList(result));
    }

    /**
     * 이름을 입력받는 메서드
     *
     * @return 이름을 저장하는 ArrayList를 반환한다
     */
    public static ArrayList<String> inputName() {
        System.out.println(GameMessage.NAME_INPUT.getMessage());

        String input = in.nextLine();
        String[] names = input.split(",");
        return new ArrayList<>(Arrays.asList(names));
    }

    public static String inputCommand() {
        System.out.println(GameMessage.PLAYER_WHO_WANTS_TO_SEE_RESULT.getMessage());
        return in.next();
    }
}
