package domain.gameResult;

import java.util.List;

public class GameResultPrecondition {
    public static void checkUsers(List<String> users, int maxLength) {
        isNotEmptyList(users);
        isLegal(users, maxLength);
    }

    public static void checkResults(List<String> results, int maxLength, int expectedResultLength) {
        isNotEmptyList(results);
        isLegal(results, maxLength);
        checkSize(results, expectedResultLength);
    }

    private static void isLegal(List<String> users, int maxLength) {
        if (isIllegal(users, maxLength)) {
            throw new IllegalArgumentException("사람의 이름은 5글자 이내여야 합니다.");
        }
    }

    private static boolean isIllegal(List<String> users, int maxLength) {
        return
                users.stream()
                        .map(String::length)
                        .anyMatch(length -> length > maxLength);
    }

    private static void isNotEmptyList(List<String> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException("한명 이상의 사람을 입력해주세요.");
        }
    }

    private static void checkSize(List<String> results, int expectedResultLength) {
        if (results.size() != expectedResultLength) {
            throw new IllegalArgumentException("결과값의 수는 입력한 유저수와 동일해야 합니다.");
        }
    }

}
