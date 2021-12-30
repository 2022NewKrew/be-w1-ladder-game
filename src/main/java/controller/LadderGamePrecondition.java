package controller;

import java.util.List;

public class LadderGamePrecondition {
    public static void checkUsers(List<String> userList, int MAX_LENGTH) {
        isNotEmptyList(userList);
        isLegalUsers(userList, MAX_LENGTH);
    }

    private static void isLegalUsers(List<String> users, int MAX_LENGTH) {
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
}
