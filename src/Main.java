import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = getPositiveIntFromScanner(scanner, "참여할 사람은 몇 명인가요? ");
        int height = getPositiveIntFromScanner(scanner, "사다리 높이는 몇개인가요? ");

        Ladder ladder = new Ladder(numOfPeople, height);
        System.out.println(ladder);
    }

    /**
     * @return {@code scanner}로부터 입력받은 양의 정수
     */
    private static int getPositiveIntFromScanner(Scanner scanner, String prompt) {
        int input;
        System.out.print(prompt);
        while (!scanner.hasNextInt() || (input = scanner.nextInt()) <= 0) {
            System.out.println("** 양의 정수를 입력해주세요 **");
            scanner.next();
        }
        return input;
    }
}
