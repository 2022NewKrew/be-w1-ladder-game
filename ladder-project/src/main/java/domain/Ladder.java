package domain;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int line;
    private final List<List<Boolean>> ladder;

    public Ladder(int column, int height) {
        this.ladder = createLadderList(column - 1, height);
        this.line = generateRandomLine();
        assert this.line > -1;
        initLadder();
    }

    private List<List<Boolean>> createLadderList(int column, int height) {
        List<List<Boolean>> ladderList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderList.add(createLadderColumnList(column));
        }
        return ladderList;
    }

    private List<Boolean> createLadderColumnList(int column) {
        List<Boolean> ladderColumnList = new ArrayList<>();
        for (int i = 0; i < column; i++) {
            ladderColumnList.add(false);
        }
        return ladderColumnList;
    }

    private void initLadder() {
        for (int i = 0; i < line; i++) {
            int rowPosition = RandomUtil.generateSpecificRange(ladder.size());
            int columnPosition = RandomUtil.generateSpecificRange(ladder.get(0).size());
            boolean result = checkLinePositionValidate(rowPosition, columnPosition);
            ladder.get(rowPosition).set(columnPosition, result);
        }
    }

    private boolean checkLinePositionValidate(int rowPosition, int columnPosition) {
        if (columnPosition - 1 >= 0 && ladder.get(rowPosition).get(columnPosition - 1)) {
            return false;
        }
        if (columnPosition + 1 < ladder.get(0).size() && ladder.get(rowPosition).get(columnPosition + 1)) {
            return false;
        }
        return true;
    }

    public List<List<Boolean>> getLadder() {
        return ladder;
    }

    private int generateRandomLine() {
        return RandomUtil.generateSpecificRange(getLadderSize());
    }

    private int getLadderSize() {
        return ladder.size() * ladder.get(0).size();
    }
}
