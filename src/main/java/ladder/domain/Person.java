package ladder.domain;

public class Person {
    private final String name;
    private static final int MIN_LENGTH_OF_NAME = 1;
    private static final int MAX_LENGTH_OF_NAME = 5;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        int nameLength = name.length();
        if (nameLength < MIN_LENGTH_OF_NAME || nameLength > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("사람의 이름은 1글자 이상, 5글자 이하여야합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
