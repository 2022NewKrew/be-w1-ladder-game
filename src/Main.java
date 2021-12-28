import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = _getIntFromScanner(scanner, "참여할 사람은 몇 명인가요? ");
        int height = _getIntFromScanner(scanner, "사다리 높이는 몇개인가요? ");

        Ladder ladder = new Ladder(count, height);
        System.out.println(ladder);
    }

    /**
     * @return {@code scanner}로부터 입력받은 양의 정수
     */
    private static int _getIntFromScanner(Scanner scanner, String prompt) {
        int input = -1;

        do {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input <= 0) {
                    System.out.println("** 양수를 입력해주세요 **");
                }
            } else {
                System.out.println("** 정수를 입력해주세요 **");
                scanner.next();
            }
        } while (input <= 0);

        return input;
    }
}