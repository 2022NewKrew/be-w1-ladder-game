import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final Scanner in = new Scanner(System.in);

    /**
     * 입력이 올바른지 확인하는 메서드
     * @param input 입력받은 인자를 받는다
     * @throws InputMismatchException 양수가 아니면 예외를 던진다
     */
    private static void validateInput(int input) throws InputMismatchException {
        if (input <= 0)
            throw new InputMismatchException();
    }

    /**
     * 사람 수를 입력 받는 메서드
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    static int inputNumberOfPlayer() throws InputMismatchException {
        System.out.println("참여할 사람은 몇 명인가요?");

        int numberOfPlayer = in.nextInt();
        validateInput(numberOfPlayer);
        return numberOfPlayer;
    }

    /**
     * 사다리 높이를 입력 받는 메서드
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    static int inputHeight() throws InputMismatchException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int height = in.nextInt();
        validateInput(height);
        return height;
    }
}
