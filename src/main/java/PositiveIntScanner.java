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
                return parsePositiveInt(scanner.nextLine());
            } catch (PositiveIntException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
    }

    private int parsePositiveInt(String s) {
        int value = parseInt(s);
        if (value < 1) {
            throw new PositiveIntException("양의 정수를 입력하세요.");
        }
        return value;
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new PositiveIntException("정수형을 입력하세요.");
        }
    }
}
