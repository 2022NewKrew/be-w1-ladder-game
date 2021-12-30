package ladder;

import exception.InvalidBridgeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderSimpleGame extends LadderGame {

    private final Random randomInstance = new Random();

    public void createBridge() {
        int row = this.getLadderHeight();
        int col = this.getNumberOfParticipants() - 1;
        this.setBridge(createLadderMap(row, col));
        checkInvalidBridge();
    }

    private List<Boolean> createNoneContinueTrueList(int col) {

        List<Boolean> map = new ArrayList<>();
        boolean previousColumnValue = false;

        for (int i = 0; i < col; i++) {
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

    public void checkInvalidBridge() {
        for (List<Boolean> list : this.getBridge()) {
            checkInvalidContinueTrueList(list);
        }
    }

    private void checkInvalidContinueTrueList(List<Boolean> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) && list.get(i + 1)) throw new InvalidBridgeException("연속된 다리는 생성할 수 없습니다.");
        }
    }
}
