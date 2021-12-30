package controller;

import java.util.List;

public class LadderGamePrecondition {
    public static void checkUsers(List<String> userList, int maxLength) {
        isNotEmptyList(userList);
        isLegalUsers(userList, maxLength);
    }

    private static void isLegalUsers(List<String> users, int maxLength) {
        if (isIllegal(users, maxLength)) {
            throw new IllegalArgumentException("사람의 이름은 5글자 이내여야 합니다.");
        }
    }

    private static boolean isIllegal(List<String> users, int maxLength) {
        return users.stream().anyMatch(userName -> userName.length() > maxLength);
    }

    private static void isNotEmptyList(List<String> userList) {
        if (userList.isEmpty()) {
            throw new IllegalArgumentException("한명 이상의 사람을 입력해주세요.");
        }
    }
}
