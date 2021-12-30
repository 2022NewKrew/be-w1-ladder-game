package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderSimpleGame extends LadderGame {


    private final Random randomInstance = new Random();


    public void createBridge() {
        int row = this.getLadderHeight();
        int col = this.getNumberOfParticipants() - 1;
        this.setBridge(createLadderMap(row, col));
    }

    private List<Boolean> createNoneContinueTrueList(int col) {

        List<Boolean> map = new ArrayList<>();
        boolean previousColumnValue = false;

        for (int j = 0; j < col; j++) {
            boolean isBridge = (!previousColumnValue) && trueAndFalseGenerator();
            map.add(isBridge);
            previousColumnValue = isBridge;
        }

        return map;
    }

    private List<List<Boolean>> createLadderMap(int row, int col) {

        List<List<Boolean>> ladderMap = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            List<Boolean> list = createNoneContinueTrueList(col);
            ladderMap.add(list);
        }

        return ladderMap;
    }

    private boolean trueAndFalseGenerator() {
        return randomInstance.nextBoolean();
    }
}
