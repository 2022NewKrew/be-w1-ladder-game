import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final String PLAYER_INPUT_MESSAGE = "참여할 사람은 몇 명인가요?";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요";
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final int MAX_NAME_LENGTH = 5;
    private static final Scanner in = new Scanner(System.in);

    /**
     * 입력이 올바른지 확인하는 메서드
     *
     * @param input 입력받은 인자를 받는다
     * @throws InputMismatchException 양수가 아니면 예외를 던진다
     */
    private static void validateInput(int input) throws InputMismatchException {
        if (input <= 0)
            throw new InputMismatchException();
    }

    /**
     * 사람 수를 입력 받는 메서드
     *
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    static int inputNumberOfPlayer() throws InputMismatchException {
        System.out.println(PLAYER_INPUT_MESSAGE);

        int numberOfPlayer = in.nextInt();
        validateInput(numberOfPlayer);
        return numberOfPlayer;
    }

    /**
     * 사다리 높이를 입력 받는 메서드
     *
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    static int inputHeight() throws InputMismatchException {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);

        int height = in.nextInt();
        validateInput(height);
        return height;
    }

    private static void validateInputName(String Name) throws InputMismatchException {
        if (Name.length() == 0 || Name.length() > MAX_NAME_LENGTH)
            throw new InputMismatchException();
    }

    static ArrayList<String> inputName() throws InputMismatchException {
        System.out.println(NAME_INPUT_MESSAGE);

        String input = in.nextLine();
        String[] names = input.split(",");
        for (String name: names) {
            validateInputName(name);
        }
        return new ArrayList<>(Arrays.asList(names));
    }
}
