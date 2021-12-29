package rubam.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final int people;
    private final int height;
    private final List<Line> ladder = new ArrayList<>();
    private final List<String> names = new ArrayList<>();

    private Ladder(int people, int height, List<String> names) {
        this.people = people;
        this.height = height;
        this.names.addAll(names);
        makeLadder();
    }

    public static Ladder createLadder() {
        List<String> names = InputLadderInform.inputNames();
        int num = names.size();
        int height = InputLadderInform.inputHeight();

        return new Ladder(num, height, names);
    }

    private void makeLadder() {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(people));
        }
    }

    public List<Line> getLadderData() {
        return Collections.unmodifiableList(ladder);
    }

    public List<String> getNamesData() {
        return Collections.unmodifiableList(names);
    }
}
