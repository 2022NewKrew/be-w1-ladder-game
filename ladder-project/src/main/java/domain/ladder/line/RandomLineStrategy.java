package domain.ladder.line;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RandomLineStrategy implements LineStrategy {

    @Override
    public List<Boolean> createLine(int column) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < column; i++) {
            line.add(false);
        }
        for (int i = 0; i < column; i++) {
            line.set(RandomUtil.generateSpecificRange(column), true);
        }
        return line;
    }
}
