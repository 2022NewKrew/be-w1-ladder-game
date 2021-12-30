public class Player {
    static final int MAX_NAME_LENGTH = 5;
    final String name;

    Player(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name length is " + name.length() + " while max name length is " + MAX_NAME_LENGTH + ".");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(name=\"" + name + "\")";
    }
}
