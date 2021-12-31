package view.util;

import java.util.Scanner;

public class UserInputManager {

    private static Scanner scanner = new Scanner(System.in);

    public static int getUserInputInt(String message) {
        System.out.println(message);
        int userInput = scanner.nextInt();
        scanner.nextLine(); // 버퍼비우기
        return userInput;
    }

    public static String getUserInputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
