import java.util.InputMismatchException;
import java.util.Scanner;

public class LadderBuilder {
    int numberOfPlayer = 0;
    int height = 0;

    /**
     * 입력이 올바른지 확인하는 메서드
     * @param input 입력받은 인자를 받는다
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    void validateInput(int input) throws InputMismatchException {
        if (input <= 0)
            throw new InputMismatchException();
    }

    /**
     * 입력을 받는 메서드
     * @throws InputMismatchException 양의 정수가 아닌 다른 정수가 들어오면 예외를 던진다
     */
    void input() throws InputMismatchException {
        Scanner in = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfPlayer = in.nextInt();
        validateInput(numberOfPlayer);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = in.nextInt();
        validateInput(height);
    }

    /**
     * 새로운 사다리를 만드는 메서드
     * @return 새 사다리를 반환한다
     */
    Ladder buildLadder() {
        return new Ladder(numberOfPlayer, height);
    }
}
