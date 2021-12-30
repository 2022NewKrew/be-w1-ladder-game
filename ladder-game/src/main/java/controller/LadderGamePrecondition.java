package controller;

import java.util.List;

public class LadderGamePrecondition {
    public static void checkUsers(List<String> userList, int MAX_LENGTH) {
        isNotEmptyList(userList);
        isLegal(userList, MAX_LENGTH);
    }

    public static void checkResults(List<String> resultList, int MAX_LENGTH, int LENGTH_OF_USERS) {
        isNotEmptyList(resultList);
        isLegal(resultList, MAX_LENGTH);
        checkLengthOfResults(resultList, LENGTH_OF_USERS);
    }

    private static void isLegal(List<String> users, int MAX_LENGTH) {
        if (isIllegal(users, MAX_LENGTH)) {
            throw new IllegalArgumentException("사람의 이름은 5글자 이내여야 합니다.");
        }
    }

    private static boolean isIllegal(List<String> users, int MAX_LENGTH) {
        return users.stream().anyMatch(userName -> userName.length() > MAX_LENGTH);
    }

    private static void isNotEmptyList(List<String> userList) {
        if (userList.isEmpty()) {
            throw new IllegalArgumentException("한명 이상의 사람을 입력해주세요.");
        }
    }

    private static void checkLengthOfResults(List<String> resultList, int LENGTH_OF_USERS) {
        if (resultList.size() != LENGTH_OF_USERS) {
            throw new IllegalArgumentException("유저수와 동일한 갯수의 결과값을 입력해주세요");
        }
    }
}
