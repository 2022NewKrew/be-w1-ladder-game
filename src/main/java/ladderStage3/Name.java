package ladderStage3;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다");
        }
    }
}
