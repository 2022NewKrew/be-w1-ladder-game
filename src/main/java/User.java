public class User {

    private static final int maxLengthOfName = 5;

    private final String name;

    public User(String name) {
        this.name = name;
        validateName();
    }

    public String getName() {
        return name;
    }

    public int getLengthOfName() {
        return name.length();
    }

    public static int getMaxLengthOfName() {
        return maxLengthOfName;
    }

    private void validateName() {
        if (name.length() > maxLengthOfName) {
            throw new IllegalStateException("이름은 최대 5글자까지 가능합니다.");
        }
    }
}
