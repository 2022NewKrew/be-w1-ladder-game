package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.util.RandomUtil;

public class Line {

    private final List<Boolean> bridges;

    private Line(ArrayList<Boolean> bridges) {
        this.bridges = new ArrayList<>(bridges);
    }

    public static Line makeLine(int countOfPerson) {
        ArrayList<Boolean> bridges = new ArrayList<>();
        int LineWidth = countOfPerson - 1;
        for (int i = 0; i < LineWidth; i++) {
            bridges.add(makeBridge(i, bridges));
        }
        return new Line(bridges);
    }

    private static boolean makeBridge(int index, ArrayList<Boolean> bridges) {
        return RandomUtil.generateBoolean() && !hasLeftBridge(index, bridges);
    }

    private static boolean hasLeftBridge(int index, ArrayList<Boolean> bridges) {
        if (index == 0) {
            return false;
        }
        return bridges.get(index - 1);
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(this.bridges);
    }
}