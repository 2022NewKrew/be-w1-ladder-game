package TypeScanner;

import java.util.Scanner;

public interface BaseScanner<T> {
    Scanner scanner = new Scanner(System.in);

    default T getValueWithQuestion(String question) {
        System.out.println(question);
        while (true) {
            try {
                T value = parse(scanner.nextLine());
                validate(value);
                return value;
            } catch (TypeScannerException e) {
                System.out.println("사용자 입력 오류: " + e.getMessage());
            }
        }
    }

    T parse(String s);

    default void validate(T value) {};
}
