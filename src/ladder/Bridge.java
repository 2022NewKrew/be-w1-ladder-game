package ladder;

//사다리의 각 케이스 정의
public enum Bridge {
    DEFAULT('|'), EMPTY(' '), EXIST('-');
    char value;

    Bridge(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
