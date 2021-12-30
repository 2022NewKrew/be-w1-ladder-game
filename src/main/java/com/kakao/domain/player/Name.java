package com.kakao.domain.player;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";

    private final String originalName;

    public Name(String originalName) {
        validate(originalName);
        this.originalName = originalName;
    }

    private void validate(String originalName) {
        if (originalName.isBlank()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if (originalName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }

    public String refine() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
            .append(BLANK.repeat((MAX_NAME_LENGTH - originalName.length()) / 2))
            .append(originalName)
            .append(BLANK.repeat(MAX_NAME_LENGTH - stringBuilder.length()));
        return stringBuilder.toString();
    }

    public String getOriginalName() {
        return originalName;
    }
}
