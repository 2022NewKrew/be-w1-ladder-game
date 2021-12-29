import java.util.InputMismatchException;
import java.util.Scanner;
import exception.IllegalInputException;

public class PositiveIntScanner{
    private static final Scanner sc = new Scanner(System.in);

    public static int getPositiveInt(String message) {
        System.out.println(message);
        while (true) {
            try {
                return parsePositiveInt(sc.nextLine());
            } catch (IllegalInputException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
    }

    private static int parsePositiveInt(String s) {
        int value = parseInt(s);
        if (value < 1) {
            throw new IllegalInputException("양의 정수를 입력하세요.");
        }
        return value;
    }

    private static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalInputException("정수형을 입력하세요.");
        }
    }
}
