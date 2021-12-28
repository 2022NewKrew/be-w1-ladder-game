public class Ladder {
    // 불변
    private final int people;
    private final int height;

    public Ladder(int people, int height) {
        this.people = people;
        this.height = height;
    }

    public int getPeople() {
        return people;
    }

    public int getHeight() {
        return height;
    }
}
