package view;

import java.util.*;

public class UserInput {
    static private final Scanner scanner = new Scanner(System.in);

    static public int getLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return scanner.nextInt();
        } catch (Exception exception) {
            throw new IllegalArgumentException("올바른 사다리 높이를 입력해 주세요 (양의 정수)");
        }

    }

    static public List<String> getUserList() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String inputLine = scanner.nextLine();
            List<String> userList = Arrays.asList(inputLine.split(","));
            return Collections.unmodifiableList(userList);
        } catch (Exception exception) {
            throw new IllegalArgumentException("올바른 방법으로 이름을 입력해주세요");
        }

    }

    public static List<String> getLadderResult() {
        try {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String inputLine = scanner.nextLine();
            List<String> userList = Arrays.asList(inputLine.split(","));
            return Collections.unmodifiableList(userList);
        } catch (Exception exception) {
            throw new IllegalArgumentException("올바른 방법으로 결과를 입력해주세요");
        }
    }

    public static String getTarget() {
        try {
            System.out.println("결과를 보고 싶은 사람은?");
            return scanner.next();
        } catch (Exception exception) {
            throw new IllegalArgumentException("올바른 방법으로 결과를 입력해주세요");
        }
    }

}
