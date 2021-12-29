package main.ladder.domain;

public class Participant {
    public static final int MAX_LENGTH_OF_PARTICIPANT_NAME = 5;

    private final String name;

    public Participant(String name) {
        this.name = name;
    }

    /**
     * 최대 이름 입력 제한 글자수를 기준으로 가운데로 위치시킨 문자열을 반환한다.
     */
    public String getNameCenterAligned() {
        int totalLength = MAX_LENGTH_OF_PARTICIPANT_NAME + 1;
        int prefixOffset = (totalLength - name.length() - 1) / 2;
        int suffixOffset = totalLength - prefixOffset - name.length();
        return " ".repeat(prefixOffset) + name + " ".repeat(suffixOffset);
    }

}
