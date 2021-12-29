package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class CustomScanner {
    private final Scanner scanner;

    public CustomScanner() {
        this.scanner = new Scanner(System.in);
    }

    public int nextBoundedInt(int infimum, int supremum, String message){
        Integer value;
        System.out.println(message);

        do {
            value = verifyIntInput(infimum, supremum);
        } while (value == null);

        return value;
    }

    private Integer verifyIntInput(int infimum, int supremum){
        int value;
        try{
            value = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("정수 값을 입력해 주세요.");
            scanner.nextLine();
            return null;
        }

        if(infimum > value || value > supremum) {
            System.out.println(infimum + " 이상 " + supremum + " 이하의 값을 입력해 주세요.");
            return null;
        }

        return value;
    }

    public String nextLimitedLengthString(int maxLength, String message){
        String value;
        System.out.println(message);

        do {
            value = verifyStringInput(maxLength);
        } while (value == null);

        return value;
    }

    private String verifyStringInput(int maxLength){
        String value = scanner.next();

        if(value.length() > 5) {
            System.out.println("이름은 최대 5자까지 입력할 수 있습니다.");
            return null;
        }

        return value;
    }
}
