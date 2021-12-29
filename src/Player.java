public class Player {
    final String name;
    static final int MAX_NAME_LENGTH = 5;

    Player(String name) throws Exception {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new Exception("Name length is " + name.length() + " while max name length is " + MAX_NAME_LENGTH + ".");
        }
        this.name = name;
    }
}
