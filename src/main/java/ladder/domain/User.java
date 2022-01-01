package ladder.domain;

public class User {
    static final int MAX_NAME_LEN = 5;
    private final String name;


    public User(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %d를 넘을 수 없습니다.", MAX_NAME_LEN));
        }
    }

    @Override
    public String toString() {
        final String PRINT_FORMAT = "%-" + MAX_NAME_LEN + "." + MAX_NAME_LEN + "s ";
        return String.format(PRINT_FORMAT, name);
    }
}
