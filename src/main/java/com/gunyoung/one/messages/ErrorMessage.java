package com.gunyoung.one.messages;

public final class ErrorMessage {

    private ErrorMessage() {
    }

    public static final String LADDER_NOT_INITIALIZED = "Ladder is not initialized";
    public static final String EMPTY_USER_NAME = "참여할 사람의 이름을 입력해야합니다.";
    public static final String WRONG_LADDER_HEIGHT = "사다리의 높이는 1 이상이여야 합니다.";
}
