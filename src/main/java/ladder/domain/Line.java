package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.util.RandomUtil;

public class Line {

    public static final String NOT_EXIST_BRIDGE = " ";
    private static final String EXIST_BRIDGE = "-";
    public static final String LADDER_STICK = "|";

    private final List<String> bridges;

    private Line(ArrayList<String> bridges) {
        this.bridges = new ArrayList<>(bridges);
    }

    public static Line makeLine(int countOfPerson) {
        ArrayList<String> bridges = new ArrayList<>();
        int LineWidth = countOfPerson * 2 - 1;
        for (int i = 0; i < LineWidth; i++) {
            bridges.add(i % 2 == 0 ? LADDER_STICK : makeBridge());
        }
        return new Line(bridges);
    }

    private static String makeBridge() {
        return RandomUtil.generateBoolean() ? EXIST_BRIDGE : NOT_EXIST_BRIDGE;

    }

    public List<String> getBridges() {
        return Collections.unmodifiableList(this.bridges);
    }
}
