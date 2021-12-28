package ladderStage2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> line;
    private static final Random random = new Random();

    public Line(int participantCount) {
        this.line = this.create(participantCount);
    }

    public List<Boolean> create(int participantCount) {
        List<Boolean> temp = new ArrayList<>();
        for (int count = 0; count < participantCount - 1; count++) {
            temp.add(random.nextBoolean());
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(boolean b : line) {
            sb.append("|");
            sb.append(b ? "-" : " ");
        }
        sb.append("|");
        return sb.toString();
    }
}
