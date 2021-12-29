import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final int MAX_NUM_STRING = 5;
    private static final String SEPARATOR = ",";

    Scanner scanner = new Scanner(System.in);

    public List<String> inputUserInfo() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String[] users = scanner.nextLine().split(SEPARATOR);

            checkUserNames(users);

            return Arrays.asList(users);
        } catch (IllegalArgumentException iae) {
            System.out.println("이름은 " + MAX_NUM_STRING + "글자를 넘어갈 수 없습니다.");
            return inputUserInfo();
        }
    }

    private void checkUserNames(String[] users) {
        if (Arrays.stream(users).allMatch(user -> user.length() <= MAX_NUM_STRING))
            throw new IllegalArgumentException();
    }

    public int inputLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return inputPositiveInt();
        } catch (IllegalArgumentException iae) {
            System.out.println("사다리 높이는 양의 정수여야 합니다.");
            return inputLadderHeight();
        }
    }

    private int inputPositiveInt() {
        int value = scanner.nextInt();
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public void printLadderGame(List<String> userList, Ladder ladder) {
        printUsers(userList);
        printLadder(ladder);
    }

    private void printUsers(List<String> userList) {
        for (String user : userList) {
            System.out.printf("%" + MAX_NUM_STRING + "s ", user);
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
