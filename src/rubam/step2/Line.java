package rubam.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final int people;
    private final List<Boolean> line = new ArrayList<>();

    public Line(int people) {
        this.people = people;
        makeLine();
    }

    private void makeLine() {
        Random random = new Random();
        for (int i = 0; i < people - 1; i++) {
            line.add(random.nextBoolean());
        }
    }

    public List<Boolean> getLineData() {
        return new ArrayList<>(line);
    }
}
