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

    public int nextPositiveInt() throws PositiveIntException {
        try {
            int value = scanner.nextInt();
            if (value < 1) {
                throw new PositiveIntException("오류: 입력값은 0보다 커야합니다.");
            }
            return value;
        } catch (InputMismatchException e) {
            throw new PositiveIntException("오류: 입력값은 정수여야 합니다.");
        }
    }
}
