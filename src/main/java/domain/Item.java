package domain;


public class Item {
    static final int MAX_NAME_LENGTH = 5;
    public final String name;

    public Item(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name length is " + name.length() + " while max name length is " + MAX_NAME_LENGTH + ".");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "model.Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
