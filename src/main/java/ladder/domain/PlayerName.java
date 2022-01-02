package ladder.domain;

import ladder.exception.NameLengthException;

public class PlayerName {
    private String name;
    private static final int MAX_LENGTH = 5;

    public PlayerName(String name) {
        this.name = name;
    }


    //플레이어 이름 길이 검증
    public void checkNameLength() {
        if (name.length() > MAX_LENGTH) {
            throw new NameLengthException(MAX_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
