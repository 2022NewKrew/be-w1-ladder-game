public class User {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public User(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalStateException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    public void printUser() {
        System.out.printf("%-" + MAX_LENGTH_OF_NAME + "s ", name);
    }
}
