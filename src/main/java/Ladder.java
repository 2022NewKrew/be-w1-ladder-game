import java.util.List;

public class Ladder {

    private final int people;
    private final int height;
    private List<List<String>> ladderShape;

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

    public List<List<String>> getLadderShape() {
        return ladderShape;
    }

    public void setLadderShape(List<List<String>> ladderShape) {
        this.ladderShape = ladderShape;
    }
}
