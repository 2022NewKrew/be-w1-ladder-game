package ladder.domain;

/**
 * MAX_NAME_LEN 사용처
 * InputView에서 이름 자를 때
 * LadderFloor toString 메소드에서 사다리 출력시 폭을 결정
 * Ladder print 메소드에서 사람 이름 출력시 간격 결정
 */
public enum LadderConfig {
    //이름의 max 값에 따라 사다리의 폭이 결정됨
    MAX_NAME_LEN(5);

    private final int value;

    LadderConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
