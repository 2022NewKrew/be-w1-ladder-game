package ladder.domain;

public class Person {

    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        int nameLength = name.length();
        if (nameLength <= 0 || nameLength > 5) {
            throw new IllegalArgumentException("이름은 최소 1글자 이상, 5글자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
