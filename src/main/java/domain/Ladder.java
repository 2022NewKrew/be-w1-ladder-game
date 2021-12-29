package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int people;
    private final int height;
    private List<Line> ladderShape;

    public Ladder(int people, int height) {
        this.people = people;
        this.height = height;
        this.ladderShape = new ArrayList<Line>();
    }

    public int getPeople() {
        return people;
    }

    public int getHeight() {
        return height;
    }

    public List<Line> getLadderShape() {
        return ladderShape;
    }

    public void setLadderShape(List<Line> ladderShape) {
        this.ladderShape = ladderShape;
    }
}
