package view;

import java.util.Scanner;

public class ScreenMessage {

    private ScreenMessage() {
    }

    public static int inputToInt(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String inputToString(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.next();
    }
}
