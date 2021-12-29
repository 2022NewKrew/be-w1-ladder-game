package Step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final int people;
    private final List<Boolean> line = new ArrayList<>();
    private final Random random = new Random();

    public Line(int people) {
        this.people = people;
        makeLine();
    }

    private void makeLine() {
        line.add(random.nextBoolean());
        for(int i=1; i<people-1; i++) {
            line.add(!line.get(i - 1) && random.nextBoolean());
        }
    }

    public StringBuilder getLine() {
        StringBuilder sb = new StringBuilder("|");

        for(Boolean b : line) {
            sb.append(b ? "-----|" : "     |");
        }

        return sb;
    }
}
