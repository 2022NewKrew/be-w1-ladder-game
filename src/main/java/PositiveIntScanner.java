import java.util.InputMismatchException;
import java.util.Scanner;

public class PositiveIntScanner {
    private final Scanner scanner;

    public PositiveIntScanner() {
        scanner = new Scanner(System.in);
    }

    public int getPositiveIntWithQuestion(String question) {
        System.out.println(question);
        while (true) {
            try {
                return nextPositiveInt();
            } catch (PositiveIntException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private int nextPositiveInt() {
        int value;
        try {
            value = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new PositiveIntException("오류: 입력값은 정수여야 합니다.");
        }
        checkValid(value);
        return value;
    }

    private void checkValid(int value) {
        if (value < 1) {
            throw new PositiveIntException("오류: 입력값은 0보다 커야합니다.");
        }
    }
}
