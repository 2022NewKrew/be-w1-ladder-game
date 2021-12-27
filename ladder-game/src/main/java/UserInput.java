import java.util.Scanner;

public class UserInput {
    static private final Scanner scanner = new Scanner(System.in);

    static public int getNumberOfPeople() throws IllegalArgumentException {
        try {
            System.out.println("참여할 사람은 몇 명 인가요?");
            return scanner.nextInt();
        } catch (Exception exception) {
            throw new IllegalArgumentException("참여할 사람수를 올바르게 입력해 주세요 (양의 정수)");
        }

    }

    static public int getLadderHeight() throws IllegalArgumentException {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return scanner.nextInt();
        } catch (Exception exception) {
            throw new IllegalArgumentException("올바른 사다리 높이를 입력해 주세요 (양의 정수)");
        }

    }


}
