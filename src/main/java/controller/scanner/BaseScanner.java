package controller.scanner;

import java.util.Scanner;

public interface BaseScanner<T> {
    Scanner scanner = new Scanner(System.in);

    default T getValue() {
        try {
            T value = parse(scanner.nextLine());
            validate(value);
            return value;
        } catch (TypeScannerException e) {
            System.out.println("사용자 입력 오류: " + e.getMessage());
            return getValue();
        }
    }

    T parse(String s);

    default void validate(T value) {};
}
