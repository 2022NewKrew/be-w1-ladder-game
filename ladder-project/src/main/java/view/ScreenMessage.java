package view;

import java.util.Scanner;

public class ScreenMessage {

    private ScreenMessage() {

    }

    public static int input(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
