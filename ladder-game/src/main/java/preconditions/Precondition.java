package preconditions;

import java.util.List;

public class Precondition {
    public static void checkUsers(List<String> userList, int MAX_LENGTH) {
        isNotEmptyList(userList);
        isLegalUsers(userList, MAX_LENGTH);
    }

    public static void checkFrameLength(int frameLength, int MIN_LENGTH) {
        if (frameLength < MIN_LENGTH) {
            throw new IllegalArgumentException("참여하는 사람의 수는 양의 정수여야 합니다.");
        }
    }

    public static void checkLadderHeight(int height, int MIN_LENGTH) {
        if (height < MIN_LENGTH) {
            throw new IllegalArgumentException("사다리의 높이는 양의 정수여야 합니다.");
        }
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
