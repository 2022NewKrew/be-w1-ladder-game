package input;

import java.util.Scanner;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static int nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void close() {
        scanner.close();
    }
}
