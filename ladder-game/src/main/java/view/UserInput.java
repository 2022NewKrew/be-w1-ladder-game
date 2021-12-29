package view;

import java.util.*;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return scanner.nextInt();
        } catch (Exception exception) {
            throw new IllegalArgumentException("올바른 사다리 높이를 입력해 주세요 (양의 정수)");
        }

    }

    public static List<String> getUserList() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String inputLine = scanner.nextLine();
            List<String> userList = Arrays.asList(inputLine.split(","));
            return Collections.unmodifiableList(userList);
        } catch (Exception exception) {
            throw new IllegalArgumentException("올바른 방법으로 이름을 입력해주세요");
        }

    }


}
