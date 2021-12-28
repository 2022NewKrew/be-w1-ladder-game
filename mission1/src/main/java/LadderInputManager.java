import java.util.InputMismatchException;
import java.util.Scanner;

public class LadderInputManager {
    private final int numOfPlayer;
    private final int maxHeight;
    private Scanner scanner;

    public LadderInputManager() {
        scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPlayer = getInput();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        maxHeight = getInput();
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    private int getInput() {
        try {
            int result = scanner.nextInt();
            return checkInput(result) ? result : getInput();
        }
        catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
            return getInput();
        }
    }

    private boolean checkInput(int value) {
        if (value > 0)
            return true;
        System.out.println("0보다 큰 정수를 입력해주세요.");
        return false;
    }

}
