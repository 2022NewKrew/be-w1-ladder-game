package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {
    private LineFactory() {
    }

    public static Line create(int width) {
        Flags flags = createFlags(width);
        Line line = new Line(flags);

        return line;
    }

    private static Flags createFlags(int count) {
        List<Flag> flags = new ArrayList<Flag>();
        Boolean previous = false;
        for (int i = 0; i < count; i++) {
            Flag flag = FlagFactory.create(previous);
            flags.add(flag);
            previous = flag.getFlag();
        }

        return new Flags(flags);
    }
}
