package ladder.domain;

import org.apache.commons.lang3.StringUtils;

public class Participant {
    public static final int MAX_LENGTH_OF_PARTICIPANT_NAME = 5;

    private final String name;

    Participant(String name) {
        this.name = name;
    }

    /**
     * 최대 이름 입력 제한 글자수를 기준으로 가운데로 위치시킨 문자열을 반환한다.
     * 만약, 이름이 최대 글자수를 초과하면 최대 글자수까지만 반환한다. (예 : 6글자 -> 5글자까지만 출력)
     */
    public String getNameCenterAligned() {
        return StringUtils.center(StringUtils.substring(name, 0, MAX_LENGTH_OF_PARTICIPANT_NAME), MAX_LENGTH_OF_PARTICIPANT_NAME);
    }

}
