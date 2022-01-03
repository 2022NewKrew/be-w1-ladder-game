package ladder.domain;

import java.util.UUID;

public class User {
    static final int MAX_NAME_LEN = 5;
    private final String name;
    private final UUID id;


    public User(String name) {
        validateNameLength(name);
        this.id = UUID.randomUUID();
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %d를 넘을 수 없습니다.", MAX_NAME_LEN));
        }
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        final String PRINT_FORMAT = "%-" + MAX_NAME_LEN + "." + MAX_NAME_LEN + "s ";
        return String.format(PRINT_FORMAT, name);
    }
}
